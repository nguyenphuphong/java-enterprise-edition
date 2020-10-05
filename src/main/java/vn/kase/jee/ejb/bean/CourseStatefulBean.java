package vn.kase.jee.ejb.bean;

import javax.ejb.Stateful;

import vn.kase.jee.ejb.ICourseStateful;
import vn.kase.jee.ejb.exception.AuthenticationException;
import vn.kase.jee.jpa.common.AbstractPersistenceBean;
import vn.kase.jee.jpa.entity.Course;
import vn.kase.jee.jpa.entity.UserInfo;

@Stateful
public class CourseStatefulBean extends AbstractPersistenceBean implements ICourseStateful {

    private String email;

    @Override
    public void authen(String email, String password) throws AuthenticationException {
        UserInfo userInfo = findOne(UserInfo.class, "SELECT s FROM UserInfo s WHERE s.email = ?1", email);
        if (userInfo != null && password.equals(userInfo.getUser().getPassword())) {
            this.email = email;
        } else {
            throw new AuthenticationException("Wrong username or password");
        }
    }

    @Override
    public void join(Integer linkId) {
        Course course = findOne(Course.class, "SELECT c FROM Course c WHERE c.id = ?1", linkId);
        UserInfo userInfo = findOne(UserInfo.class, "SELECT s FROM UserInfo s WHERE s.email = ?1", email);
        course.getUsers().add(userInfo.getUser());

        entityManager.persist(course);
    }
}

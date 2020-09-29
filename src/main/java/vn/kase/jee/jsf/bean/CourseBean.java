package vn.kase.jee.jsf.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import vn.kase.jee.common.ObjectMapper;
import vn.kase.jee.jpa.entity.UserInfo;
import vn.kase.jee.jsf.common.AbstractPersistenceBean;
import vn.kase.jee.jsf.pojo.Course;

@Named
@RequestScoped
public class CourseBean extends AbstractPersistenceBean {
    private Course selectedCourse = new Course();

    @PostConstruct
    public void intit() {
    }

    public List<Course> getCourses() {
        return ObjectMapper.listMapping(findAll(Course.class, "SELECT s FROM Course s"), Course.class);
    }

    public boolean isShowList() {
        return count(vn.kase.jee.jpa.entity.Course.class) != 0;
    }

    public boolean isEdit() {
        return selectedCourse.getId() != null && selectedCourse.getId() != 0;
    }

    public boolean isCreate() {
        return !isEdit();
    }

    @Transactional
    public void createOrUpdate() {
        if (isEdit()) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("id", selectedCourse.getId());
            vn.kase.jee.jpa.entity.Course beingSelectedCourse = findOne(vn.kase.jee.jpa.entity.Course.class, "SELECT c FROM Course c WHERE c.id = :id", parameters);

            beingSelectedCourse.setTitle(selectedCourse.getTitle());
            beingSelectedCourse.setDescription(selectedCourse.getDescription());

            entityManager.persist(beingSelectedCourse);
        } else {
            vn.kase.jee.jpa.entity.Course course = new vn.kase.jee.jpa.entity.Course();
            course.setTitle(selectedCourse.getTitle());
            course.setDescription(selectedCourse.getDescription());

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("email", getSession().getEmail());
            UserInfo info = findOne(UserInfo.class, "SELECT u FROM UserInfo u WHERE u.email = :email", parameters);
            course.setUser(info.getUser());

            entityManager.persist(course);
            
            selectedCourse.setId(course.getId());
        }
    }

    public void reset() {
        selectedCourse = new Course();
    }

    public void select(Integer courseId) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", courseId);
        ObjectMapper.simpleMapping(
                findOne(vn.kase.jee.jpa.entity.Course.class, "SELECT c FROM Course c WHERE c.id = :id", parameters),
                selectedCourse);
    }

    public Course getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(Course selectedCourse) {
        this.selectedCourse = selectedCourse;
    }
}

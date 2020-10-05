package vn.kase.jee.ejb.bean;

import java.util.List;

import javax.ejb.Stateless;

import vn.kase.jee.common.ObjectMapper;
import vn.kase.jee.ejb.ICourseStateless;
import vn.kase.jee.ejb.pojo.Course;
import vn.kase.jee.jpa.common.AbstractPersistenceBean;

@Stateless
public class CourseStatelessBean extends AbstractPersistenceBean implements ICourseStateless {

    @Override
    public List<Course> getAllCourses() {
        return ObjectMapper.listMapping(findAll(vn.kase.jee.jpa.entity.Course.class, "SELECT c FROM Course c"), Course.class);
    }
}

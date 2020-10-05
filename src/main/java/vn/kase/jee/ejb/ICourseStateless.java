package vn.kase.jee.ejb;

import java.util.List;

import javax.ejb.Remote;

import vn.kase.jee.ejb.pojo.Course;

@Remote
public interface ICourseStateless {
    List<Course> getAllCourses();
}

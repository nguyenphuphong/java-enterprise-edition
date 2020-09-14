package vn.kase.jee.jsf.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import vn.kase.jee.jsf.pojo.Course;

@Named
@RequestScoped
public class CourseBean {
    private List<Course> courses;

    @PostConstruct
    public void intit() {
        courses = new ArrayList<>();

        Course course = new Course();
        course.setTitle("Java Programming");
        course.setDescription("KASE ACCPi introduce a new course for Java Programming");

        courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}

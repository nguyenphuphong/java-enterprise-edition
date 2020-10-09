package vn.kase.jee.jms.producer;

import vn.kase.jee.jms.pojo.CourseMessage;

public interface ICourseProducer {
    void send(CourseMessage course);
}

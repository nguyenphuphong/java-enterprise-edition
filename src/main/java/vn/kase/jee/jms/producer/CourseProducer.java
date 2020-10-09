package vn.kase.jee.jms.producer;

import javax.annotation.Resource;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Topic;

import vn.kase.jee.jms.pojo.CourseMessage;

@Default
public class CourseProducer implements ICourseProducer {
    @Resource
    private ConnectionFactory cf;

    @Resource(name = "courseTopic")
    private Topic queue;

    @Inject
    private JMSContext context;

    @Override
    public void send(CourseMessage courseMessage) {
        context.createProducer().send(queue, context.createObjectMessage(courseMessage));
    }
}

package vn.kase.jee.jms.listener;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import vn.kase.jee.jms.pojo.CourseMessage;
import vn.kase.jee.jpa.common.AbstractPersistenceBean;
import vn.kase.jee.jpa.entity.Course;
import vn.kase.jee.jpa.entity.UserInfo;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "courseTopic"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic") })
public class CourseListener extends AbstractPersistenceBean implements MessageListener {
    private static final Logger LOGGER = Logger.getLogger(CourseListener.class.getName());

    @Override
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            CourseMessage course = (CourseMessage) objectMessage.getObject();
            
            Course entity = new Course();
            entity.setTitle(course.getTitle());
            entity.setDescription(course.getDescription());

            UserInfo info = findOne(UserInfo.class, "SELECT u FROM UserInfo u WHERE u.email = ?1", course.getEmail());
            entity.setUser(info.getUser());

            entityManager.persist(entity);
        } catch (JMSException e) {
            LOGGER.log(Level.SEVERE, "Can't receive Message", e);
        }
    }
    
}

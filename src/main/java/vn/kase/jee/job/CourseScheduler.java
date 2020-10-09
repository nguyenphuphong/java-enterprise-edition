package vn.kase.jee.job;

import java.util.logging.Logger;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
@Lock(LockType.READ)
public class CourseScheduler {
    private static final Logger LOGGER = Logger.getLogger(CourseScheduler.class.getName());
    
    @Schedule(second = "10", minute = "*", hour = "*")
    public void run() {
        LOGGER.info("This is Scheduler");
    }
}

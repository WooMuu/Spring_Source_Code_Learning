package chapter6.application_event_multicaster;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by zjb on 2019/10/28.
 */
public class TestListener implements ApplicationListener {


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof TestEvent) {
            ((TestEvent) event).print();
        }
    }
}

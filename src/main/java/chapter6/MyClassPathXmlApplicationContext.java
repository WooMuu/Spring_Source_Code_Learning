package chapter6;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zjb on 2019/10/22.
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {
    public MyClassPathXmlApplicationContext(String[] configLocations) {
        super(configLocations);
    }

    @Override
    protected void initPropertySources() {
        getEnvironment().setRequiredProperties("VAR");
    }
}

package chapter6;

import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zjb on 2019/10/22.
 */
public class Test {
    private static final String[] configLocations = {"${chapter6}/test.xml"};

    @Before
    public void before(){
        System.getProperties().setProperty("chapter6", "chapter6");
    }
    @org.junit.Test
    public void test() {
        String[] configLocations = {"${chapter6}/test.xml"};
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configLocations, true);
        context.getBean("hello");
    }

    @org.junit.Test
    public void testMyClasspathXmlApplicationContext() {
        MyClassPathXmlApplicationContext context = new MyClassPathXmlApplicationContext(configLocations);
        context.getBean("hello");
    }
}

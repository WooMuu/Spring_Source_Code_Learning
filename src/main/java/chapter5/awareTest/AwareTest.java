package chapter5.awareTest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zjb on 2019/10/22.
 */
public class AwareTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("chapter5/app.xml");
        Test test = (Test)context.getBean("test");
        test.testAware();
    }
}

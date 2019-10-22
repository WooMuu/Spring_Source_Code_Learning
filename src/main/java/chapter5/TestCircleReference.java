package chapter5;

import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zjb on 2019/10/21.
 */
public class TestCircleReference {
    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleByConstrucor() throws Throwable {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("chapter5/test.xml");
        } catch (Exception e) {
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }

    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleBySetterAndPrototype() throws Throwable {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("chapter5/test2.xml");
            context.getBean("testA");

        } catch (Exception e) {
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }

    }
}

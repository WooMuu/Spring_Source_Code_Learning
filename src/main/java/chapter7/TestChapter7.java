package chapter7;

import chapter7.aop_demo.TestBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zjb on 2019/10/29.
 */
public class TestChapter7 {

    @Test
    public void testAOPDemo() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("chapter7/aop_demo/aop_config.xml");
        TestBean bean = (TestBean) context.getBean("testBean");
        bean.test();
    }
}

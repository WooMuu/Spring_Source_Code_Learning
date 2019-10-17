package chapter2;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by zjb on 2019/10/14.
 */
@SuppressWarnings("deprecation")
public class BeanFactoryTest {
    @Test
    public void test() {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        Object bean = factory.getBean("myTestBean");
        assert "testStr".equals(((TestBean) bean).getStr());
    }
}

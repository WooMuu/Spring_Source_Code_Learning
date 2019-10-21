package chapter4;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by zjb on 2019/10/16.
 */
public class BeanFactoryTest {
    public static void main(String[] args) {
//        XmlBeanFactory parentBeanFactory = new XmlBeanFactory(new ClassPathResource("chapter4_parent.xml"));
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("chapter4.xml"));
//        factory.setParentBeanFactory(parentBeanFactory);

//        User testbean1 = (User) parentBeanFactory.getBean("testbean");
        User testbean = (User) factory.getBean("testbean");
        User testbean2 = (User) factory.getBean("testbean");
        System.out.println(testbean.toString());
    }
}

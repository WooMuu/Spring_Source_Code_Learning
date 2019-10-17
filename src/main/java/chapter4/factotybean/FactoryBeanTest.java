package chapter4.factotybean;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by zjb on 2019/10/17.
 */
public class FactoryBeanTest {
    public static void main(String[] args) {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("chapter4/factoryBean.xml"));
        Car car = (Car) factory.getBean("car");
        System.out.println(car.toString());
    }
}

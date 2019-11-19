package chapter13.with_spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by zjb on 2019/11/19.
 */
public class HelloWorldReceiver {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:chapter13/applicationContext.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
        Destination destination = (Destination) context.getBean("destination");

        try {
            TextMessage msg = (TextMessage) jmsTemplate.receive(destination);
            System.out.println(msg.getText().toString());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

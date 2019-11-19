package chapter13.without_spring;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by zjb on 2019/11/18.
 */
public class Sender {
    public static void main(String[] args) {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.8.128:61616");
        Connection connection = null;
        Session session = null;
        try {
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("my-queue");
            MessageProducer producer = session.createProducer(destination);
            for (int i = 0; i < 3; i++) {
                TextMessage message = session.createTextMessage("大家好，这是一个测试" + i);
                TimeUnit.SECONDS.sleep(1);
                producer.send(message);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                session.commit();
                session.close();
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}

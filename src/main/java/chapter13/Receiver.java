package chapter13;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by zjb on 2019/11/18.
 */
public class Receiver {
    public static void main(String[] args) {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.8.128:61616");
        Connection connection = null;
        Session session = null;
        try {
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("my-queue");
            MessageConsumer consumer = session.createConsumer(destination);
            int i = 0;
            while (i < 3) {
                i++;
                TextMessage message = (TextMessage) consumer.receive();
                session.commit();
                System.out.println("接收到消息：" + message.getText());
            }

        } catch (JMSException e) {
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

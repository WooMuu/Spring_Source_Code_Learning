package chapter13.with_spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by zjb on 2019/11/19.
 */
public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            String msg = ((TextMessage) message).getText();
            System.out.println(msg);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

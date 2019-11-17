package chapter12;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zjb on 2019/11/17.
 */
public class ClientTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:chapter12/client.xml");
        HttpInvokerTest1 httpInvokerTest1 = (HttpInvokerTest1)app.getBean("remoteService");
        String hahah = httpInvokerTest1.getTestPo("hahah");
        System.out.println(hahah);
    }
}

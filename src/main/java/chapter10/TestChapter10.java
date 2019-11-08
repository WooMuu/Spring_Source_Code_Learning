package chapter10;

import chapter8.pojo.User;
import chapter8.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zjb on 2019/11/4.
 */
public class TestChapter10 {
    @Test
    public void testTrans() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:chapter10/spring_trans.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.save(new User("wade", 12, "male"));
    }
}

package chapter10;

import chapter8.pojo.User;
import chapter8.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by zjb on 2019/11/4.
 */
public class TestChapter10 {

    UserService service;
    private ApplicationContext context;

    @org.junit.Before
    public void before() {
        context = new ClassPathXmlApplicationContext("classpath:chapter10/spring_trans.xml");
        service = (UserService) context.getBean("userService");
    }

    @Test
    public void testTrans() {
        List<User> users = service.getUsers();
        System.out.println(users);
    }

    @Test
    public void testSave() {
        service.save(new User("4444", 12, "male"));
    }

}

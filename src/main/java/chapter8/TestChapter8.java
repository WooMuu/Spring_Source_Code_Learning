package chapter8;

import chapter8.pojo.User;
import chapter8.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;
import java.util.List;

/**
 * Created by zjb on 2019/11/1.
 */
public class TestChapter8 {
    @Test
    public void testDriverManagerOfOracle() {
        Connection connection = null;
        try {
//            System.setProperty("jdbc.drivers", "mysql");
//            DriverManager.setLogWriter(new PrintWriter(System.out));
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "rsems", "rsems");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM d_user");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                for (int i = 1; ; i++) {
                    try {
                        Object object = resultSet.getObject(i);
                        if (object == null) {
                            continue;
                        }
                        System.out.print(object);
                        System.out.print("   ");
                    } catch (SQLException e) {
                        System.out.println();
                        break;

                    }
                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testDriverManagerOfMysql() {
        Connection connection = null;
        try {
//            System.setProperty("jdbc.drivers", "mysql");
//            DriverManager.setLogWriter(new PrintWriter(System.out));
            connection = DriverManager.getConnection("jdbc:mysql://root:root@localhost/spring_source_code_leaning?"
                    + "useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=Asia/Shanghai");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                for (int i = 1; ; i++) {
                    try {
                        Object object = resultSet.getObject(i);
                        if (object == null) {
                            continue;
                        }
                        System.out.print(object);
                        System.out.print("   ");
                    } catch (SQLException e) {
                        System.out.println();
                        break;

                    }
                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testUserService() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:chapter8/datasource.xml");
        UserService userService = (UserService) context.getBean("userService");

        User user = new User("jim", 11, "man");
        userService.save(user);
        List<User> users = userService.getUsers();
        System.out.println(users);
    }
}

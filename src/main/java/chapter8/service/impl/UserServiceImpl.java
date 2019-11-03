package chapter8.service.impl;

import chapter8.mapper.UserMapper;
import chapter8.pojo.User;
import chapter8.service.UserService;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

/**
 * Created by zjb on 2019/11/1.
 */
public class UserServiceImpl implements UserService {
    private JdbcTemplate template;

    public void setDataSource(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(User user) {
        int update = template.update(
                "INSERT into user(name,age,sex) VALUES (?,?,?)",
                new Object[]{user.getName(), user.getAge(), user.getSex()},
                new int[]{Types.VARCHAR, Types.INTEGER, Types.VARCHAR});
    }

    @Override
    public List<User> getUsers() {
        List<User> users = template.query(
                "select * from user",
                new UserMapper());
        return users;
    }
}

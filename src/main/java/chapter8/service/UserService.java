package chapter8.service;

import chapter8.pojo.User;

import java.util.List;

/**
 * Created by zjb on 2019/11/1.
 */
public interface UserService {
    public void save(User user);

    public List<User> getUsers();

}

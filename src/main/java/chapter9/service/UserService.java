package chapter9.service;

import chapter8.pojo.User;

/**
 * Created by zjb on 2019/11/20.
 */
public interface UserService {
    void insertUser(User user);

    User getUser(int id);

    User getUserByName(String name);
}

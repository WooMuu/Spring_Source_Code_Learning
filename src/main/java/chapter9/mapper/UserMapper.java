package chapter9.mapper;


import chapter8.pojo.User;

/**
 * Created by zjb on 2019/11/3.
 */
public interface UserMapper {

    void insertUser(User user);

    User getUser(int id);

    User getUserByName(String name);
}

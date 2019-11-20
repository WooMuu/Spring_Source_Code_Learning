package chapter9.service.impl;


import chapter8.pojo.User;
import chapter9.mapper.UserMapper;
import chapter9.service.UserService;

/**
 * Created by zjb on 2019/11/20.
 */
public class UserServiceImpl implements UserService {

    public UserMapper mapper;

    @Override
    public void insertUser(User user) {
        mapper.insertUser(user);
    }

    @Override
    public User getUser(int id) {
        return mapper.getUser(id);
    }

    @Override
    public User getUserByName(String name) {
        return mapper.getUserByName(name);
    }

    public UserMapper getMapper() {
        return mapper;
    }

    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }
}

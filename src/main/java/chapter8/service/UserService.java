package chapter8.service;

import chapter8.pojo.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zjb on 2019/11/1.
 */
@Transactional(propagation = Propagation.REQUIRED)
public interface UserService {
    public void save(User user);

    public List<User> getUsers();
}

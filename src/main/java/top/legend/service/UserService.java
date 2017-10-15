package top.legend.service;

import top.legend.repository.po.User;

import java.util.List;

/**
 * Created by Legend on 2017/10/15.
 */
public interface UserService {

    List<User> findAll();

    User find(String id);

    User save(User user);


}

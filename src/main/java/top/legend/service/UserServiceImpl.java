package top.legend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.legend.repository.UserRepository;
import top.legend.repository.po.User;

import java.util.List;
import java.util.Objects;

/**
 * Created by Legend on 2017/10/15.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {

        Integer integer = Objects.requireNonNull(1, "");

        return userRepository.findAll();


    }

    @Override
    public User find(String id) {
        return userRepository.findOne(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}

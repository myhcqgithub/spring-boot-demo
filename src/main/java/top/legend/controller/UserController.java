package top.legend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.legend.repository.po.User;
import top.legend.service.UserService;

import java.util.List;

/**
 * Created by Legend on 2017/10/14.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User find(@PathVariable("id") String id) {
        return userService.find(id);
    }


    @PostMapping
    public  User  save(@RequestBody User user){
        return userService.save(user);
    }
}

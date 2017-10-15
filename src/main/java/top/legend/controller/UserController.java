package top.legend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.legend.repository.po.User;
import top.legend.service.UserService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Legend on 2017/10/14.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(getClass());
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
    public User save(@Valid @RequestBody User user, BindingResult bindingResult) {
        logger.info("save");
        return userService.save(user);
    }
    @PostMapping("/save")
    public User save2( @RequestBody User user) {
        logger.info("save2");
        return userService.save(user);
    }

    @PutMapping
    public void put(String id) {
        logger.info(id);
    }
}

package org.community.app.controller;

import org.community.app.service.UserService;
import org.community.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by frodoking on 2016/12/26.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<User> all() {
        return  userService.getAll();
    }

    @GetMapping(value = "/user/{id}")
    public User view(@PathVariable Integer id) {
        return  userService.getById(id);
    }
}

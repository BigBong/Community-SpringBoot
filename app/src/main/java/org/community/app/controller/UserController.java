package org.community.app.controller;

import org.community.app.service.UserService;
import org.community.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by frodoking on 2016/12/26.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}")
    public User view(@PathVariable Integer id) {
        return  userService.getById(id);
    }

    @RequestMapping(value = "/list")
    public List<User> all() {
        return  userService.getAll();
    }
}

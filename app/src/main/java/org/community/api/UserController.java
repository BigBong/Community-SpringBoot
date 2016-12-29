package org.community.api;

import org.community.service.UserService;
import org.community.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by frodoking on 2016/12/26.
 */
@RestController
@RequestMapping("/api")
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

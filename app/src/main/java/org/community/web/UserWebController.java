package org.community.web;

import org.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by frodoking on 2017/1/6.
 */
@Controller
@RequestMapping("/web")
public class UserWebController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "user";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}

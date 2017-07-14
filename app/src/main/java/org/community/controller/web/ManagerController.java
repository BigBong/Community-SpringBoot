package org.community.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by frodoking on 2017/7/14.
 */
@Controller
@RequestMapping("/web/admin")
public class ManagerController {

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    @GetMapping("/home")
    public String home() {
        return "admin/home";
    }
}

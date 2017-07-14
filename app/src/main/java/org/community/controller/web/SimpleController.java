package org.community.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by frodoking on 2016/12/26.
 */
@Controller
public class SimpleController {

    @GetMapping("/")
    public String home() {
        return "redirect:/web/admin/home";
    }

    @GetMapping("/web/freedom/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }
}

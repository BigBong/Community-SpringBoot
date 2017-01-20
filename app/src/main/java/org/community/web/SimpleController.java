package org.community.web;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by frodoking on 2016/12/26.
 */
@Controller
public class SimpleController {

    @GetMapping("/")
    public String home() {
        return "redirect:/web/index";
    }

    @GetMapping("/web/index")
    public String index() {
        return "index";
    }

    @GetMapping("/web/oauth2")
    public String oauth2() {
        return "oauth2";
    }

    @GetMapping("/web/test/{type}/{value}")
    public String test(@PathVariable String type, @PathVariable String value, Model model) {
        StringBuilder sb = new StringBuilder();
        if (type.equalsIgnoreCase("BCrypt")) {
            model.addAttribute("title", "BCryptEncoder");
            sb.append(String.format("[%s: %s], ", value, new BCryptPasswordEncoder().encode(value)));
        }
        model.addAttribute("info", sb.toString());
        return "test";
    }
}

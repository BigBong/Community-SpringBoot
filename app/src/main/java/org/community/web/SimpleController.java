package org.community.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/web/test")
    public String test(Model model) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[admin: %s], ", encoder.encode("admin")));
        sb.append(String.format("[web: %s], ", encoder.encode("web")));
        sb.append(String.format("[mobile: %s], ", encoder.encode("mobile")));
        model.addAttribute("title", "BCryptPasswordEncoder");
        model.addAttribute("info", sb.toString());
        return "test";
    }
}

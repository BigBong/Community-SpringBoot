package org.community.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by frodoking on 2016/12/26.
 */
@Controller
public class SimpleController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}

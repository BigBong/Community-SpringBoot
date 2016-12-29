package org.community.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by frodoking on 2016/12/26.
 */
@Controller
@RequestMapping("/web")
public class SimpleController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}

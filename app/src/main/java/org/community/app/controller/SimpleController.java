package org.community.app.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by frodoking on 2016/12/26.
 */
@RestController
public class SimpleController {

    @RequestMapping("index")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}

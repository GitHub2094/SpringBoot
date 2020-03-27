package com.lsm.frame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @RequestMapping("/index")
    public String hello(Model m) {
        m.addAttribute("name", "thymeleaf");
        return "index";
    }
}
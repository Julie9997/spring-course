package ru.julie.task1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/private-data")
    public String privateData() {
        return "private-data.html";
    }

    @GetMapping("/public-data")
    public String publicData() {
        return "public-data.html";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login.html";
    }
}

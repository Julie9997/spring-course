package ru.julie.s4task2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class RandomController {

    @GetMapping("/random")
    public String getRandom(Model model) {
        model.addAttribute("number", new Random().nextInt(100));
        return "random";
    }
}

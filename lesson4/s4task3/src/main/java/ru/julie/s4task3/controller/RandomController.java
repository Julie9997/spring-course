package ru.julie.s4task3.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RandomController {

    @Value("${magic-min:3}") // из properties,через двоеточие дефолт (если нет файла, например)
    private Integer defaultMin;
    @Value("${magic-max:1000}")
    private Integer defaultMax;

    @GetMapping("/random/{min}/{max}")
    public String getRandom(@PathVariable("min") int min,
                            @PathVariable("max") int max,
                            Model model) {
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("number", new Random().nextInt(min, max + 1));
        return "random";
    }

    @GetMapping("/random")
    public String getRandomWithParam(@RequestParam("min") Integer min,
                            @RequestParam("max") Integer max,
                            Model model) {
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("number", new Random().nextInt(min, max + 1));
        return "random";
    }
}

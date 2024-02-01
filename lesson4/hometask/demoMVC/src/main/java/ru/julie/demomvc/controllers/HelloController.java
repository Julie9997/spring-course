package ru.julie.demomvc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.julie.demomvc.models.User;
import ru.julie.demomvc.services.UserService;

@Controller
@AllArgsConstructor
public class HelloController {

    private UserService userService;

    @GetMapping("/hello")
    public String getHello() {
        return "hello.html";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/users")
    public String getUsers(User user, Model model) {
        userService.addUser(user);
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
}

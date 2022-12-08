package ru.kata.spring.boot_security.demo.controllers;


import com.mysql.cj.protocol.AuthenticationProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;
    private UserRepository userRepository;
    private AuthenticationProvider authenticationProvider;

    @GetMapping("/admin")
    public String startPage(Model model, Principal principal) {
        model.addAttribute("users", userService.getAllProfiles());
        return "/admin";
    }

    @GetMapping("/user")
    public String startPage(Principal principal, Model model) {
        User user = userRepository.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "user";

    }
}

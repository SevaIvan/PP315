package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserRepository userRepository;
}

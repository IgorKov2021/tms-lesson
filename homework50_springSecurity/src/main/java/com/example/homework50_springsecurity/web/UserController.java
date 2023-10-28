package com.example.homework50_springsecurity.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequestMapping("")
public class UserController {
    @GetMapping("/private")
    public String privatePage() {
        return "private";
    }

    @GetMapping("/public")
    public String publicPage() {
        return "public";
    }
}

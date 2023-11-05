package com.example.homework50_springsecurity.web;

import com.example.homework50_springsecurity.dto.PersonDto;
import com.example.homework50_springsecurity.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@RequiredArgsConstructor

@Controller
@RequestMapping("")
public class UserController {
    private final PersonService personService;
    @GetMapping("/private")
    public ModelAndView privatePage() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        ModelAndView modelAndView = new ModelAndView("private");
        modelAndView.addObject("name", name);

        return modelAndView;
    }

    @PostMapping("/public")
    public String publicPage(PersonDto personDto) {
        PersonDto save = personService.save(personDto);
        return "public";
    }

    @GetMapping("/public")
    public String publicPage() {
        return "public";
    }
}

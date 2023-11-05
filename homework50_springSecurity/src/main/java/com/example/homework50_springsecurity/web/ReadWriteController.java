package com.example.homework50_springsecurity.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping
public class ReadWriteController {

    @GetMapping("/read")
    public String read() {
        return "read";
    }

    @GetMapping("/write")
    public ModelAndView write() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<String> authorities = authentication.getAuthorities()
                .stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .collect(Collectors.toList());
        ModelAndView modelAndView = new ModelAndView("write");

        modelAndView.addObject("authorities", authorities);


        return modelAndView;
    }
}

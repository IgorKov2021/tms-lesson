package com.example.homework42_springboot.web;

import com.example.homework42_springboot.domain.StudentDto;
import com.example.homework42_springboot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService service;
    @GetMapping()
public ModelAndView getPage(@ModelAttribute(name = "student") StudentDto studentDto) {
ModelAndView modelAndView = new ModelAndView("home");
modelAndView.addObject("title", "HELLO FROM THYMELEAF");
        List<StudentDto> allStudents = service.getAll();
        modelAndView.addObject("studentsList", allStudents);
        return modelAndView;
    }
    @PostMapping
    public ModelAndView save(@ModelAttribute(name = "student") StudentDto studentDto) {
        ModelAndView modelAndView = new ModelAndView("home");
        service.save(studentDto);
        List<StudentDto> allStudents = service.getAll();
        modelAndView.addObject("studentsList", allStudents);
        return modelAndView;


    }
}

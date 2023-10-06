package com.example.homework42_springboot.web;

import com.example.homework42_springboot.domain.StudentDto;
import com.example.homework42_springboot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService service;

    @GetMapping()
    public ModelAndView getPage(@ModelAttribute(name = "student") StudentDto studentDto) {

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("title", "HELLO FROM THYMELEAF");
       // List<StudentDto> allStudents = service.getAll();
        List<StudentDto> allStudents = service.sortAll2();

        modelAndView.addObject("studentsList", allStudents);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView save(@ModelAttribute(name = "student") StudentDto studentDto) {
        ModelAndView modelAndView = new ModelAndView("home");
        service.save(studentDto);
        //List<StudentDto> allStudents = service.getAll();
        List<StudentDto> allStudents = service.sortAll2();
        modelAndView.addObject("studentsList", allStudents);
        return modelAndView;


    }

    @PostMapping("/action")
    public ModelAndView action(@RequestParam(name = "id") UUID id, @RequestParam(name = "action") String action) {
        ModelAndView modelAndView = new ModelAndView("home");
        if (action.equals("UP")) {
            service.upNumber(id);
        }
        if (action.equals("DOWN")) {
            service.downNumber(id);
        }
        List<StudentDto> studentDtos = service.sortAll();
        modelAndView.addObject("studentsList", studentDtos);
        modelAndView.addObject("student", new StudentDto());
        return modelAndView;
    }

}

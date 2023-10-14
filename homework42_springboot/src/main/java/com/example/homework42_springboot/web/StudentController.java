package com.example.homework42_springboot.web;

import com.example.homework42_springboot.domain.StudentDto;
import com.example.homework42_springboot.domain.StudentSearchDto;
import com.example.homework42_springboot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService service;

    @GetMapping()
    public ModelAndView getPage(@ModelAttribute(name = "student") StudentDto studentDto, @ModelAttribute(name = "studentSearch") StudentSearchDto searchDto) {

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("title", "HELLO FROM THYMELEAF");
        // List<StudentDto> allStudents = service.getAll();
        List<StudentDto> allStudents = service.sortAll2();


        modelAndView.addObject("studentsList", allStudents);


        return modelAndView;
    }

    @PostMapping
    public ModelAndView save(@ModelAttribute(name = "student") @Valid StudentDto studentDto, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("home");
        int errorCount = result.getErrorCount();
        if (errorCount == 0) {
            service.save(studentDto);
        }

        //List<StudentDto> allStudents = service.getAll();
        List<StudentDto> allStudents = service.sortAll2();
        modelAndView.addObject("studentsList", allStudents);
        modelAndView.addObject("studentSearch", new StudentSearchDto());
        return modelAndView;


    }

    @PostMapping("/action")
    public ModelAndView action(@RequestParam(name = "id") UUID id, @RequestParam(name = "action") String action) {
        ModelAndView modelAndView = new ModelAndView("home");

        if (action.equals("UP")) {
            service.upStudentPosition(id);
        }
        if (action.equals("DOWN")) {
            service.downStudentPosition(id);
        }

        List<StudentDto> studentDtos = service.sortAll();

        modelAndView.addObject("studentsList", studentDtos);
        modelAndView.addObject("student", new StudentDto());
        modelAndView.addObject("studentSearch", new StudentSearchDto());

        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(@ModelAttribute(name = "studentSearch") @Valid StudentSearchDto searchDto, BindingResult result) {
        List<StudentDto> studentsSearch = service.search(searchDto);
        studentsSearch.sort((n1, n2) -> n1.getNumber() - n2.getNumber());
        ModelAndView modelAndView = new ModelAndView("home");

        modelAndView.addObject("studentsList", studentsSearch);

        modelAndView.addObject("student", new StudentDto());

        return modelAndView;
    }

}

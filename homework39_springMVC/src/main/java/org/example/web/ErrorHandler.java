package org.example.web;

import org.example.exceptions.ExceptionNumber1;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice

public class ErrorHandler {
    @ExceptionHandler(ExceptionNumber1.class)
    public ModelAndView errorPage(ExceptionNumber1 exception) {
        ModelAndView modelAndView = new ModelAndView("errorPage");
        String author = exception.getAuthor();
        modelAndView.addObject("author", author);
        return modelAndView;
    }
}

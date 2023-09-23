package org.example.web;

import lombok.RequiredArgsConstructor;
import org.example.domain.Book;
import org.example.exceptions.ExceptionNumber1;
import org.example.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("")
public class WebController {
    final private BookService bookService;

    @GetMapping(value = "/")
    public String getPage() {
        return "start";
    }

    @PostMapping(value = "/")
    public ModelAndView addBook(@Valid Book book, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("start");
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError error : fieldErrors) {
            String field = error.getField();
            String defaultMessage = error.getDefaultMessage();
            modelAndView.addObject(field + "_error", "Field: " + field + " " + defaultMessage);

        }
        int errorCount = bindingResult.getErrorCount();
        if (errorCount == 0) {
            bookService.save(book);
        }
        //bookService.getAll();
        return modelAndView;
    }

    @PostMapping(value = "/show")
    public ModelAndView showAll(Book book) {
        ModelAndView modelAndView = new ModelAndView("start");
        List<Book> all = bookService.getAll();
        modelAndView.addObject("all", all);
        return modelAndView;
    }

    @PostMapping(value = "/search")
    public ModelAndView searchBooks(
            @RequestParam(value = "title") String name) {

        ModelAndView modelAndView = new ModelAndView("start");
        List<Book> all = bookService.searchBooks(name);
        //List<Book> all = bookService.getAll();
        modelAndView.addObject("all", all);
        return modelAndView;
    }
}

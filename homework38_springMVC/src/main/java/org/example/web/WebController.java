package org.example.web;

import org.example.domain.Book;
import lombok.AllArgsConstructor;
import org.example.service.BookTitleSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/")
@AllArgsConstructor
public class WebController {



    private BookTitleSearchService bookTitleSearchService;

    @GetMapping(value = "/books")
    public String getPage() {
        return "home";
    }

    @PostMapping(value = "/books")
    public ModelAndView getAuthors(
            @RequestParam(value = "title") String name) {

        ModelAndView modelAndView = new ModelAndView("home");

        List<Book> books = bookTitleSearchService.getBooks(name);

        if (books.size() == 0) {
            String message = "Books with title: " + name + " are not found";
            modelAndView.addObject("message", message);
        } else {
            modelAndView.addObject("books", books);
        }

        return modelAndView;

    }
}

package org.example.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Getter
public class ExceptionNumber1 extends RuntimeException{
    private String author;
}

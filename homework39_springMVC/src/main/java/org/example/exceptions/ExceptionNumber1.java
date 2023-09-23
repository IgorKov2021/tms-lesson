package org.example.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class ExceptionNumber1 extends RuntimeException {
    private String author;
}

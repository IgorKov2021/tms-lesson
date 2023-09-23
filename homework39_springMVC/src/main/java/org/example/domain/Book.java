package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@AllArgsConstructor

public class Book {
        private UUID id;

        @NotBlank
        private String title;
        private String author;
        @Min(1)
        private Integer pages;
}

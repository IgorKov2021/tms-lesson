package org.example.service;

import org.example.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookTitleSearchService {
    List<Book> getBooks(String title);
}

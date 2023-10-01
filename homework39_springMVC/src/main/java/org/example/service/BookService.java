package org.example.service;

import org.example.domain.Book;

import java.util.List;

public interface BookService {
    void save(Book book);
    List<Book> getAll();

    public List<Book> searchBooks(String title);
}

package org.example.Impl;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.example.domain.Book;
import org.example.exceptions.ExceptionNumber1;
import org.example.service.BookRowMapper;
import org.example.service.BookService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(Book book) {

        if (StringUtils.containsAny(book.getAuthor(), "0123456789")) {
            throw new ExceptionNumber1(book.getAuthor());
        }

        book.setId(UUID.randomUUID());
        jdbcTemplate.update("insert into books (id, title, author, pages) values (?,?,?,?)", book.getId(),
                book.getTitle(), book.getAuthor(), book.getPages());

    }

    @Override
    public List<Book> getAll() {
        List<Book> query = jdbcTemplate.query("Select * from books", new BookRowMapper());
        return query;
    }

    @Override
    public List<Book> searchBooks(String title) {
        List<Book> query = jdbcTemplate.query("Select * from books WHERE books.title = ?", new Object[]{title}, new BookRowMapper());
        System.out.println();
        return query;
    }

}

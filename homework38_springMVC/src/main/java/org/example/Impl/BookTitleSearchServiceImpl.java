package org.example.Impl;

import org.example.domain.Book;
import org.example.service.BookTitleSearchService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookTitleSearchServiceImpl implements BookTitleSearchService {
    final List<Book> bookList = List.of(new Book("Title1", "Tolstoy", 150),
            new Book("Title2", "Tolstoy", 300),
            new Book("Title3", "Tolstoy", 200),
            new Book("Title1", "Marshak", 400));
    @Override
    public List<Book> getBooks(String title) {

       /* boolean b = bookList.stream()
                .anyMatch(book -> book.getTitle().equals(title));

       if(b != true) {
           throw new IllegalArgumentException();        }*/

            //String author = bookList.stream().filter(book -> book.getTitle().equals(title)).findFirst().get().getAuthor();


        List<Book> collect = bookList.stream()
                    .filter(book -> book.getTitle().equals(title)).collect(Collectors.toList());

            return collect;
    }
}

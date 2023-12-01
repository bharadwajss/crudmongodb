package com.ssb.crudmongdb.service;

import com.ssb.crudmongdb.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Object addBook(Book book);

    List<Book> getAllBooks();

    Optional<Book> getBook(int bookId);
}

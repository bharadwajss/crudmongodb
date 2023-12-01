/**
 * @author:Satish Bharatiya
 * @date: 11/29/2023
 */
package com.ssb.crudmongdb.service;

import com.ssb.crudmongdb.controller.BookController;
import com.ssb.crudmongdb.model.Book;
import com.ssb.crudmongdb.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    BookRepository bookRepository;
    @Override
    public Object addBook(Book book) {
        try {
            LOGGER.info("Entering into a method addBook for bookId {}"+book.getId());
            bookRepository.save(book);
        }
        catch (Exception exception){
            LOGGER.error("Error while executing the method addBook from BookServiceImpl" +book.getId());
        }
        return "book Added";
    }

    @Override
    public List<Book> getAllBooks() {
        LOGGER.info("Entering into a method getAllBooks");
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBook(int bookId) {
        LOGGER.info("Entering into a method getBook for bookId"+bookId);
        return bookRepository.findById(bookId);
    }
}

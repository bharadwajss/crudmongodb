/**
 * @author:Satish Bharatiya
 * @date: 11/29/2023
 */
package com.ssb.crudmongdb.controller;

import com.ssb.crudmongdb.model.Book;
import com.ssb.crudmongdb.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        try {
            bookService.addBook(book);
            LOGGER.info("Calling the book controller class", book.getId());
            return new ResponseEntity<>(book, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(book, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        try {
            bookService.getAllBooks();
            LOGGER.info("Calling the getAllBooks() method from BookController class");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getBook/{id}")
    public ResponseEntity<Book>getBook(@PathVariable("id") int bookId) {
        Optional<Book> getBook = bookService.getBook(bookId);
        LOGGER.info("Calling the getBook() method from BookController class {}", bookId);
        if (getBook.isPresent()) {
            return new ResponseEntity<Book>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

package com.example.springAdvances.controller;

import com.example.springAdvances.entities.Book;
import com.example.springAdvances.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        bookRepository.saveAndFlush(book);
        return book;
    }

    @GetMapping(path = "/find")
    public List<Book> findAll() {
        List<Book> all = bookRepository.findAll();
        return all;
    }

    @GetMapping(path = "/find_title")
    public List<Book> findAllByTitle(@RequestParam(name = "title") String title) {
        List<Book> allByTitle = bookRepository.findAllByTitle(title);
        return allByTitle;
    }

    @GetMapping(path = "/find_ibsn")
    public Optional<Book> findBookByIsbn(@RequestParam(name = "ibsn") String ibsn) {
        Optional<Book> bookByIsbn = bookRepository.findBookByIsbn(ibsn);
        return bookByIsbn;
    }

    @GetMapping(path = "/")
    public Optional<Book> findBookByAuthorAndIsbn(String author, String isbn) {
        Optional<Book> bookByAuthorAndIsbn = bookRepository.findBookByAuthorAndIsbn(author, isbn);
        return bookByAuthorAndIsbn;
    }


//    public List<Book> findTop3ByAuthorOrderByPagesNumDesc(String author) {
//
//    }
//
//    public List<Book> findAllByTitleStartingWith(String titlePattern) {
//
//    }
//
//    public List<Book> findAllByPagesNumBetween(int numberOne, int numberTwo) {
//
//    }
//
//    public List<Book> findWherePagesNumIsGreaterThanX(Integer number) {
//
//    }
}

package com.example.springAdvances.repository;

import com.example.springAdvances.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitle(String title);

    Optional<Book> findBookByIsbn(String ibsn);

    Optional<Book> findBookByAuthorAndIsbn(String author, String isbn);

    List<Book> findTop3ByAuthorOrderByPagesNumDesc(String author);

    List<Book> findAllByTitleStartingWith(String titlePattern);

    List<Book> findAllByPagesNumBetween(int numberOne, int numberTwo);

    @Query(value = "SELECT f FROM Book f where f.pagesNum >=:num", nativeQuery = false)
    List<Book> findWherePagesNumIsGreaterThanX(@Param("num") int number);

}

package com.example.repository;

import com.example.dto.BookDTO;
import com.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM librarymanagementsystem.books", nativeQuery = true)
    List<Book> findAllBooks();
}
package com.example.repository;

import com.example.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM librarymanagementsystem.books", nativeQuery = true)
    List<Book> findAllBooks();
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM librarymanagementsystem.books WHERE id =:id", nativeQuery = true)
    void deleteById(@Param("id") Long id);

}
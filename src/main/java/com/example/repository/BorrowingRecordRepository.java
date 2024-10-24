package com.example.repository;

import com.example.entity.BorrowingRecord;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord,Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE librarymanagementsystem.borrowing_record SET book_id = NULL WHERE book_id =:bookId", nativeQuery = true)
//    @Query(value = "DELETE FROM librarymanagementsystem.borrowingRecord WHERE book_id = :bookId", nativeQuery = true)

    void deleteByBookId(@Param("bookId") Long bookId);
}

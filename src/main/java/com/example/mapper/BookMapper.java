package com.example.mapper;

import com.example.dto.BookDTO;
import com.example.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {BorrowingRecordMapper.class})
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO toDTO(Book book);

    Book toEntity(BookDTO bookDTO);
}
//
//import com.example.dto.BookDTO;
//import com.example.dto.BorrowingRecordDTO;
//import com.example.entity.Book;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class BookMapper {
//
//    private final BorrowingRecordMapper borrowingRecordMapper;
//
//    public BookMapper(BorrowingRecordMapper borrowingRecordMapper) {
//        this.borrowingRecordMapper = borrowingRecordMapper;
//    }
//
//    public BookDTO toDTO(Book book) {
//        if (book == null) {
//            return null;
//        }
//
//        BookDTO bookDTO = new BookDTO();
//        bookDTO.setId(book.getId());
//        bookDTO.setTitle(book.getTitle());
//        bookDTO.setAuthor(book.getAuthor());
//        bookDTO.setPublicationYear(book.getPublicationYear());
//        bookDTO.setIsbn(book.getIsbn());
//
//        List<BorrowingRecordDTO> borrowingRecords = book.getBorrowingRecords().stream()
//                .map(borrowingRecordMapper::toDTO)
//                .collect(Collectors.toList());
//        bookDTO.setBorrowingRecords(borrowingRecords);
//
//        return bookDTO;
//    }
//
//    public Book toEntity(BookDTO bookDTO) {
//        if (bookDTO == null) {
//            return null;
//        }
//
//        Book book = new Book();
//        book.setId(bookDTO.getId());
//        book.setTitle(bookDTO.getTitle());
//        book.setAuthor(bookDTO.getAuthor());
//        book.setPublicationYear(bookDTO.getPublicationYear());
//        book.setIsbn(bookDTO.getIsbn());
//
//        return book;
//    }
//}
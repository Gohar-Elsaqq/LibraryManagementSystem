package com.example.service;

import com.example.dto.BookDTO;
import com.example.entity.Book;
import com.example.exception.ResourceNotFoundException;
import com.example.mapper.BookMapper;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;
    //add book
    public BookDTO saveBook(BookDTO bookDTO) {

        if (bookDTO.getId() != null) {
            var bookId = bookRepository.findById(bookDTO.getId());
            if (bookId.isPresent()) {
                var bookEntity = bookMapper.toEntity(bookDTO);
                var updatedBook = bookRepository.save(bookEntity);
                return bookMapper.toDTO(updatedBook);
            } else {
                throw new ResourceNotFoundException ("Book with ID " + bookDTO.getId() + " not found.");
            }
        } else {
            var bookEntity = bookMapper.toEntity(bookDTO);
            var newBook = bookRepository.save(bookEntity);
            return bookMapper.toDTO(newBook);
        }
    }
    public List<BookDTO> getAllBooks() throws Exception {
        try {
            return bookRepository.findAll()
                    .stream()
                    .map(bookMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception exception) {
              throw new Exception(exception.getMessage());
        }
    }
    public List<Book> getOnlyOfBooks() {
    return bookRepository.findAllBooks();

    }

    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toDTO)
                .orElse(null);
    }

}

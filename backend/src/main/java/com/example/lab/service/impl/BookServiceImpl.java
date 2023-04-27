package com.example.lab.service.impl;

import com.example.lab.entity.AuthorEntity;
import com.example.lab.entity.BookEntity;
import com.example.lab.entity.dto.BookDTO;
import com.example.lab.entity.enums.Category;
import com.example.lab.repository.AuthorRepository;
import com.example.lab.repository.BookRepository;
import com.example.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<BookEntity> listAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
        return new BookDTO(bookRepository.save(new BookEntity(bookDTO.getName(), bookDTO.getCategory(), authorRepository.findById(bookDTO.getAuthorId()).get(), bookDTO.getAvailableCopies())));
    }

    @Override
    public BookDTO deleteBook(Long id) throws Exception {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow(Exception::new);
        bookRepository.delete(bookEntity);
        return new BookDTO(bookEntity);
    }

    @Override
    public BookEntity reduceCopy(Long id) throws Exception {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow(Exception::new);
        if(bookEntity.getAvailableCopies() > 0) {
            bookEntity.setAvailableCopies(bookEntity.getAvailableCopies() - 1);
        }
        return bookRepository.save(bookEntity);
    }


    @Override
    public BookEntity findBookById(Long id) throws Exception {
        return bookRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public BookEntity editBook(Long id, BookDTO bookDTO) throws Exception {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow(Exception::new);
        bookEntity.setName(bookDTO.getName());
        bookEntity.setCategory(bookDTO.getCategory());
        bookEntity.setAuthor(authorRepository.findById(bookDTO.getAuthorId()).get());
        bookEntity.setAvailableCopies(bookDTO.getAvailableCopies());
        return bookRepository.save(bookEntity);
    }
}

package com.example.lab.service;

import com.example.lab.entity.BookEntity;
import com.example.lab.entity.dto.BookDTO;

import java.util.List;

public interface BookService {

    BookEntity findBookById(Long id) throws Exception;

    List<BookEntity> listAllBooks();

    BookDTO saveBook(BookDTO bookDTO);

    BookDTO deleteBook(Long id) throws Exception;

    BookEntity editBook(Long id, BookDTO bookDTO) throws Exception;

    BookEntity reduceCopy(Long id) throws Exception;


}

package com.example.lab.controller;

import com.example.lab.entity.BookEntity;
import com.example.lab.entity.dto.BookDTO;
import com.example.lab.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(value = "/api/")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<BookEntity> listAllBooks() {
        return bookService.listAllBooks();
    }


    @GetMapping("/books/{id}")
    public BookEntity getBook(@PathVariable(name = "id") Long id) throws Exception {
        return bookService.findBookById(id);
    }

    @PostMapping(path = "/books/add")
    public BookDTO addBook(@RequestBody BookDTO bookDTO) throws Exception {
        System.out.println("CALLED");
        return this.bookService.saveBook(bookDTO);

    }


    @PutMapping(path = "/books/edit/{id}")
    public BookEntity editBook(@PathVariable(name = "id") Long id,
                               @RequestBody BookDTO bookDTO) throws Exception {
        return bookService.editBook(id, bookDTO);
    }

    @DeleteMapping("/books/delete/{id}")
    public BookDTO deleteBook(@PathVariable Long id) throws Exception {
        return bookService.deleteBook(id);
    }

    @PostMapping("/books/reduceCopy/{id}")
    public BookEntity reduceCopy(@PathVariable(name = "id") Long id) throws Exception {
        return bookService.reduceCopy(id);
    }


}

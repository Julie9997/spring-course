package ru.julie.example2_library.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.julie.example2_library.model.Book;
import ru.julie.example2_library.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping()
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}

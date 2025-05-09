package com.example.BookStory.book.controller;

import com.example.BookStory.book.entity.Book;
import com.example.BookStory.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;


    @GetMapping("/{isbn}")
    public String showBookDetail(@PathVariable String isbn, Model model) {
        Book book = bookService.findBookByIsbn(isbn);
        model.addAttribute("book", book);
        return "detail"; // detail.html에서 책 상세 보기
    }
}

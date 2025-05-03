package com.example.BookStory.bookstory.controller;

import com.example.BookStory.bookstory.model.Book;
import com.example.BookStory.bookstory.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping("")
    public String searchBooks(@RequestParam(name = "q", defaultValue = "spring") String query, Model model) {
        model.addAttribute("books", bookService.searchBooks(query));
        model.addAttribute("keyword", query);
        return "book/list";
    }

    @GetMapping("/isbn/{isbn13}")
    public String getBookDetailByIsbn(@PathVariable String isbn13, Model model) {
        try {
            Book book = bookService.getBookByIsbn(isbn13);
            model.addAttribute("book", book);
            return "book/detail";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }



}

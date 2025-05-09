package com.example.BookStory.book.service;

import com.example.BookStory.book.entity.Book;
import com.example.BookStory.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookByIsbn(String isbn) {
        return bookRepository.findById(isbn).orElse(null);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }


}

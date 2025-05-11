package com.example.BookStory.book.service;

import com.example.BookStory.book.entity.Book;
import com.example.BookStory.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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


    public List<Book> getTopBooks() {
        return bookRepository.findTop3ByOrderByIdDesc();
    }

    public List<Book> getTopBooksByCategory(String category) {
        Pageable pageable = PageRequest.of(0, 5);  // 첫 페이지에서 5개 책만 가져오기
        return bookRepository.findBooksByCategory(category, pageable);
    }


    public List<Book> findByCategory(String category) {
        return bookRepository.findByCategory(category);
    }

    public List<Book> findByPersonalRecommendationTrue() {
        return bookRepository.findByPersonalRecommendationTrue();
    }
}

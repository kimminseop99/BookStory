package com.example.BookStory.bookstory.repository;

import com.example.BookStory.answer.Answer;
import com.example.BookStory.bookstory.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Optional<Book> findByIsbn13(String isbn13);
}

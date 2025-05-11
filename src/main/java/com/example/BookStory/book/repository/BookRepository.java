package com.example.BookStory.book.repository;

import com.example.BookStory.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findTop5ByOrderByIdDesc();
}

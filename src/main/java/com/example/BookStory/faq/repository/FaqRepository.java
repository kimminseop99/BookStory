package com.example.BookStory.faq.repository;

import com.example.BookStory.book.entity.Book;
import com.example.BookStory.faq.entity.Faq;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FaqRepository extends JpaRepository<Faq, Long> {
}
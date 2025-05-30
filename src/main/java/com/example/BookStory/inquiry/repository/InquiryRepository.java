package com.example.BookStory.inquiry.repository;

import com.example.BookStory.book.entity.Book;
import com.example.BookStory.inquiry.entity.Inquiry;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
}

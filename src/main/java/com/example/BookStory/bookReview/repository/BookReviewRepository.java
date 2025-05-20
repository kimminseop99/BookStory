package com.example.BookStory.bookReview.repository;

import com.example.BookStory.bookReview.entity.BookReview;
import com.example.BookStory.user.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookReviewRepository extends JpaRepository<BookReview, Long> {
    List<BookReview> findByWriter(SiteUser user);
}

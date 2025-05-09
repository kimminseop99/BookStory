package com.example.BookStory.review;

import com.example.BookStory.book.entity.Book;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_isbn")
    private Book book;

    private String reviewer; // 리뷰 작성자 이름 (옵션)
    private String content;  // 독후감 내용
}

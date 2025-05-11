package com.example.BookStory.book.entity;

import com.example.BookStory.review.Review;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ISBN 대신 ID로 관리 (자동 생성)

    private String title;   // 책 제목
    private String author;  // 책 저자
    private String content; // 책 내용
    private String hashtags; // 책 해시태그
    private String imageUrl;   // 책 이미지 URL
}

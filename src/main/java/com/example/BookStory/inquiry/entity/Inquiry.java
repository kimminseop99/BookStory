package com.example.BookStory.inquiry.entity;

import com.example.BookStory.user.entity.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SiteUser user;

    private String title;

    @Lob
    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();

    private boolean isPrivate;

    private String status; // 등록, 처리중, 답변완료 등
}


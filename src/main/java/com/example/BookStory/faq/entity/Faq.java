package com.example.BookStory.faq.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Faq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    @Lob
    private String answer;
    private String category;
    private LocalDateTime createdAt = LocalDateTime.now();
}


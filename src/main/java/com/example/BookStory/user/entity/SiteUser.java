package com.example.BookStory.user.entity;

import com.example.BookStory.bookReview.entity.BookReview;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "writer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookReview> bookReviews;
}

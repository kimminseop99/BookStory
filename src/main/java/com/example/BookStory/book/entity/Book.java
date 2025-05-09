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
    private String isbn;

    private String title;
    private String author;
    private String image;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Review> reviews;
}

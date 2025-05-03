package com.example.BookStory.bookstory.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 300)
    private String subtitle;

    @Column(length = 13, unique = true)
    private String isbn13;

    @Column(length = 20)
    private String price;

    @Column(length = 500)
    private String image;

    @Column(length = 500)
    private String url;
}

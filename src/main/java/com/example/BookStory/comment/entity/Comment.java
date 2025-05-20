package com.example.BookStory.comment.entity;

import com.example.BookStory.bookReview.entity.BookReview;
import com.example.BookStory.user.entity.SiteUser;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(nullable = false)
    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    @ManyToOne
    @JoinColumn(name = "writer_id", nullable = false)
    private SiteUser writer;

    @ManyToOne
    @JoinColumn(name = "book_review_id", nullable = false)
    private BookReview bookReview;
}


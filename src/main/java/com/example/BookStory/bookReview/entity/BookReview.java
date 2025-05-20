package com.example.BookStory.bookReview.entity;

import com.example.BookStory.comment.entity.Comment;
import com.example.BookStory.user.entity.SiteUser;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    // boolean 필드명도 secret으로 수정 (getter는 isSecret() 자동 생성)
    @Column(name = "is_secret")
    private boolean secret;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    @ManyToOne
    @JoinColumn(name = "writer_id", nullable = false)
    private SiteUser writer;

    @OneToMany(mappedBy = "bookReview", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;
}

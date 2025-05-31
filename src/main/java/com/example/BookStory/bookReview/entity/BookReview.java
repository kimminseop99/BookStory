package com.example.BookStory.bookReview.entity;

import com.example.BookStory.comment.entity.Comment;
import com.example.BookStory.user.entity.SiteUser;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private SiteUser writer;

    @OneToMany(mappedBy = "bookReview", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    private String hashtags; // 책 해시태그

    @ManyToMany
    private Set<SiteUser> voter;

    @Column(nullable = false)
    private int viewCount = 0;

    public void increaseViewCount(){
        this.viewCount += 1;
    }
}

package com.example.BookStory.comment.service;

import com.example.BookStory.bookReview.entity.BookReview;
import com.example.BookStory.comment.entity.Comment;
import com.example.BookStory.comment.repository.CommentRepository;
import com.example.BookStory.user.entity.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment create(String content, SiteUser writer, BookReview review) {
        Comment comment = Comment.builder()
                .content(content)
                .writer(writer)
                .bookReview(review)
                .createdAt(LocalDateTime.now())
                .build();
        return commentRepository.save(comment);
    }

    public void update(Comment comment, String content) {
        comment.setContent(content);
        comment.setModifiedAt(LocalDateTime.now());
        commentRepository.save(comment);
    }

    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }
}

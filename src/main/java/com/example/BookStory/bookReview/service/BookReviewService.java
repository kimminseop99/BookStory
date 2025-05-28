package com.example.BookStory.bookReview.service;

import com.example.BookStory.bookReview.entity.BookReview;
import com.example.BookStory.bookReview.repository.BookReviewRepository;
import com.example.BookStory.user.entity.SiteUser;
import com.example.BookStory.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookReviewService {

    private final BookReviewRepository bookReviewRepository;
    private final UserRepository userRepository;

    public List<BookReview> findAll() {
        return bookReviewRepository.findAll();
    }

    public Optional<BookReview> findById(Long id) {
        return bookReviewRepository.findById(id);
    }

    public BookReview create(String title, String content, boolean secret, String writer) {
        SiteUser persistentWriter = userRepository.findByusername(writer)
                .orElseThrow(() -> new RuntimeException("사용자 정보가 없습니다."));

        BookReview review = buildBookReview(title, content, secret, persistentWriter);
        return bookReviewRepository.save(review);
    }



    private BookReview buildBookReview(String title, String content, boolean secret, SiteUser writer) {
        return BookReview.builder()
                .title(title)
                .content(content)
                .secret(secret)
                .writer(writer)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public void update(BookReview review, String title, String content, boolean secret) {
        review.setTitle(title);
        review.setContent(content);
        review.setSecret(secret);
        review.setModifiedAt(LocalDateTime.now());
        bookReviewRepository.save(review);
    }

    public void delete(BookReview review) {
        bookReviewRepository.delete(review);
    }

    public List<BookReview> getReviewsByUser(SiteUser user) {
        return bookReviewRepository.findByWriter(user);

    }
}

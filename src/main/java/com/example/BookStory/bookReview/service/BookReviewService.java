package com.example.BookStory.bookReview.service;

import com.example.BookStory.bookReview.entity.BookReview;
import com.example.BookStory.bookReview.repository.BookReviewRepository;
import com.example.BookStory.user.entity.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookReviewService {

    private final BookReviewRepository bookReviewRepository;

    public List<BookReview> findAll() {
        return bookReviewRepository.findAll();
    }

    public Optional<BookReview> findById(Long id) {
        return bookReviewRepository.findById(id);
    }

    public BookReview create(String title, String content, boolean secret, SiteUser writer) {
        BookReview review = BookReview.builder()
                .title(title)
                .content(content)
                .secret(secret)
                .createdAt(LocalDateTime.now())
                .writer(writer)
                .build();
        return bookReviewRepository.save(review);
    }

    public void update(BookReview review, String title, String content, boolean secret) {
        review.setTitle(title);
        review.setContent(content);
        review.setSecret(secret);
        review.setModifiedAt(LocalDateTime.now());
        // 영속성 컨텍스트 내에서 변경 감지로 save() 생략 가능
    }

    public void delete(BookReview review) {
        bookReviewRepository.delete(review);
    }

    public List<BookReview> getReviewsByUser(SiteUser user) {
        return bookReviewRepository.findByWriter(user);

    }
}

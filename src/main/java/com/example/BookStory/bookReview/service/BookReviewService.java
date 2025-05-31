package com.example.BookStory.bookReview.service;

import com.example.BookStory.bookReview.entity.BookReview;
import com.example.BookStory.bookReview.repository.BookReviewRepository;
import com.example.BookStory.user.entity.SiteUser;
import com.example.BookStory.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<BookReview> searchReviews(String query) {
        if (query == null || query.isBlank()) {
            return bookReviewRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        }
        return bookReviewRepository.findByKeyword(query.trim());
    }


    public BookReview create(String title, String content, boolean secret,String hashtags, String writer) {
        SiteUser persistentWriter = userRepository.findByUsername(writer)
                .orElseThrow(() -> new RuntimeException("사용자 정보가 없습니다."));

        BookReview review = buildBookReview(title, content, secret, hashtags, persistentWriter);
        return bookReviewRepository.save(review);
    }



    private BookReview buildBookReview(String title, String content, boolean secret,String hashtags, SiteUser writer) {
        return BookReview.builder()
                .title(title)
                .content(content)
                .secret(secret)
                .createdAt(LocalDateTime.now())
                .hashtags(hashtags)
                .writer(writer)
                .build();
    }

    public void update(BookReview review, String title, String content, boolean secret, String hashtags) {
        review.setTitle(title);
        review.setContent(content);
        review.setSecret(secret);
        review.setHashtags(hashtags);
        review.setModifiedAt(LocalDateTime.now());
        bookReviewRepository.save(review);
    }

    public void delete(BookReview review) {
        bookReviewRepository.delete(review);
    }

    public List<BookReview> getReviewsByUser(SiteUser user) {
        return bookReviewRepository.findByWriter(user);

    }

    public BookReview save(BookReview review) {
        return bookReviewRepository.save(review);
    }

    @Transactional
    public void vote(BookReview review, SiteUser user) {
        if (!review.getVoter().contains(user)) {
            review.getVoter().add(user);
            bookReviewRepository.save(review);
        }
    }

    public List<BookReview> findAllOrderByViewCountDesc(String query) {
        if (query == null || query.isBlank()) {
            return bookReviewRepository.findAllByOrderByViewCountDesc();
        }
        return bookReviewRepository.findByKeywordOrderByViewCountDesc(query.trim());
    }

    public List<BookReview> findAllOrderByVotesDesc(String query) {
        if (query == null || query.isBlank()) {
            return bookReviewRepository.findAllByOrderByVoterSizeDesc();
        }
        return bookReviewRepository.findByKeywordOrderByVoterSizeDesc(query.trim());
    }

}

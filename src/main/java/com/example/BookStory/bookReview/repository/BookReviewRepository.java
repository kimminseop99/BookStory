package com.example.BookStory.bookReview.repository;

import com.example.BookStory.bookReview.entity.BookReview;
import com.example.BookStory.user.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookReviewRepository extends JpaRepository<BookReview, Long> {
    List<BookReview> findByWriter(SiteUser user);

    // 제목, 내용, 해시태그에서 검색어 포함된 리뷰 조회
    @Query("SELECT b FROM BookReview b WHERE b.title LIKE %:keyword% OR b.content LIKE %:keyword% OR b.hashtags LIKE %:keyword% ORDER BY b.createdAt DESC")
    List<BookReview> findByKeyword(@Param("keyword") String keyword);


    @Query("SELECT br FROM BookReview br ORDER BY br.viewCount DESC")
    List<BookReview> findAllByOrderByViewCountDesc();

    @Query("SELECT br FROM BookReview br WHERE " +
            "br.title LIKE %:keyword% OR br.content LIKE %:keyword% OR br.hashtags LIKE %:keyword% " +
            "ORDER BY br.viewCount DESC")
    List<BookReview> findByKeywordOrderByViewCountDesc(@Param("keyword") String keyword);

    @Query("SELECT br FROM BookReview br ORDER BY SIZE(br.voter) DESC")
    List<BookReview> findAllByOrderByVoterSizeDesc();

    @Query("SELECT br FROM BookReview br WHERE " +
            "br.title LIKE %:keyword% OR br.content LIKE %:keyword% OR br.hashtags LIKE %:keyword% " +
            "ORDER BY SIZE(br.voter) DESC")
    List<BookReview> findByKeywordOrderByVoterSizeDesc(@Param("keyword") String keyword);
}

package com.example.BookStory.book.repository;

import com.example.BookStory.book.entity.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findTop3ByOrderByIdDesc();

    @Query("SELECT b FROM Book b WHERE b.category = :category ORDER BY b.id ASC")
    List<Book> findBooksByCategory(@Param("category") String category, Pageable pageable);

    List<Book> findByCategory(String category);

    List<Book> findByPersonalRecommendationTrue();
}

package com.example.BookStory.bookstory.service;

import com.example.BookStory.bookstory.model.Book;
import com.example.BookStory.bookstory.repository.BookRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Book> searchBooks(String query) {
        String url = "https://api.itbook.store/1.0/search/" + query;
        JsonNode jsonNode = restTemplate.getForObject(url, JsonNode.class);
        JsonNode books = jsonNode.get("books");
        return Arrays.asList(objectMapper.convertValue(books, Book[].class));
    }

    public Book getBookById(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("도서를 찾을 수 없습니다. ID: " + id));
    }
    public Book getBookByIsbn(String isbn13) {
        return bookRepository.findByIsbn13(isbn13)
                .orElseThrow(() -> new IllegalArgumentException("도서를 찾을 수 없습니다. ISBN13: " + isbn13));
    }


}

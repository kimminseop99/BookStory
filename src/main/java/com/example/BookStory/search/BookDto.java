package com.example.BookStory.search;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {

    private String title;
    private String author;
    private String image;
    private String link;
    private String publisher;

    // 네이버 API에서 제공하는 필드에 맞게 생성자, 필드, 메소드 작성
}

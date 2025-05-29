package com.example.BookStory.bookReview.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookReviewForm {

    @NotBlank(message = "제목은 필수 항목입니다.")
    private String title;

    @NotBlank(message = "내용은 필수 항목입니다.")
    private String content;

    private boolean secret;

    @NotBlank(message = "해시태그를 입력해주세요.")
    private String hashtags;
}

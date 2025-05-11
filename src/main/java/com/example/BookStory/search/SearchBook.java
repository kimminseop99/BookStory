package com.example.BookStory.search;

import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

@Getter
@Setter
public class SearchBook {

    private String title;
    private String author;
    private String image;
    private String link;
    private String publisher;
    private Integer discount;

    public String discountFormatted() {
        if (discount != null) {
            return new DecimalFormat("#,###").format(discount); // 세자리마다 쉼표를 추가해서 포맷
        }
        return "Invalid Discount";
    }


    // 네이버 API에서 제공하는 필드에 맞게 생성자, 필드, 메소드 작성
}

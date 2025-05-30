package com.example.BookStory.inquiry;

import com.example.BookStory.inquiry.entity.Inquiry;
import com.example.BookStory.user.entity.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class InquiryAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Inquiry inquiry;

    @Lob
    private String content;

    @ManyToOne
    private SiteUser responder;

    private LocalDateTime answeredAt = LocalDateTime.now();
}


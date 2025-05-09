package com.example.BookStory.search;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "naver.api")
@Primary
public class NaverApiProperties {
    private String clientId;
    private String clientSecret;
}
package com.example.BookStory;

import com.example.BookStory.search.NaverApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(NaverApiProperties.class)
public class BookStoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoryApplication.class, args);
	}

}

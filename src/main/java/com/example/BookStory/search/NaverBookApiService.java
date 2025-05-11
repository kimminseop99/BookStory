package com.example.BookStory.search;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service

public class NaverBookApiService {


    private final NaverApiProperties naverApiProperties;


    public NaverBookApiService(@Qualifier("naverApiProperties") NaverApiProperties naverApiProperties) {
        this.naverApiProperties = naverApiProperties;
        System.out.println("Naver API Client ID: " + naverApiProperties.getClientId());
        System.out.println("Naver API Client Secret: " + naverApiProperties.getClientSecret());

    }


    public List<SearchBook> searchBooks(String query) throws Exception {
        String apiUrl = "https://openapi.naver.com/v1/search/book.json";

        URI uri = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("query", URLEncoder.encode(query, StandardCharsets.UTF_8.name()))
                .queryParam("display", 100)
                .queryParam("start", 1)
                .queryParam("sort", "sim")
                .build(true)
                .toUri();


        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("X-Naver-Client-Id", naverApiProperties.getClientId())
                .header("X-Naver-Client-Secret", naverApiProperties.getClientSecret())
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        // JSON 응답 파싱
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response.body());
        JsonNode itemsNode = rootNode.path("items");

        List<SearchBook> books = new ArrayList<>();
        for (JsonNode itemNode : itemsNode) {
            SearchBook searchBook = new SearchBook();
            searchBook.setTitle(itemNode.path("title").asText(""));
            searchBook.setAuthor(itemNode.path("author").asText(""));
            searchBook.setImage(itemNode.path("image").asText(""));
            searchBook.setLink(itemNode.path("link").asText(""));
            searchBook.setPublisher(itemNode.path("publisher").asText(""));
            searchBook.setDiscount(itemNode.path("discount").asInt());
            books.add(searchBook);
        }

        return books;
    }
}
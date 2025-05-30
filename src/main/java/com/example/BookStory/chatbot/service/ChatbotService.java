package com.example.BookStory.chatbot.service;

import com.example.BookStory.chatbot.util.KeywordMatcher;
import org.springframework.stereotype.Service;

@Service
public class ChatbotService {
    public String autoReply(String question) {
        if (question == null || question.isBlank()) return "질문 내용을 입력해주세요.";
        return KeywordMatcher.findMatch(question);
    }
}

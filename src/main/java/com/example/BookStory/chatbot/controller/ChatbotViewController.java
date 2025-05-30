package com.example.BookStory.chatbot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatbotViewController {

    @GetMapping("/chatbot/chatbot")
    public String chatbotPage() {
        return "chatbot/chatbot"; // src/main/resources/templates/chatbot/chatbot.html
    }
}
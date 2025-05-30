package com.example.BookStory.chatbot.controller;

import com.example.BookStory.chatbot.dto.ChatMessage;
import com.example.BookStory.chatbot.service.ChatbotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chatbot")
public class ChatbotController {
    private final ChatbotService chatbotService;

    @PostMapping("/ask")
    public Map<String, String> askBot(@RequestBody Map<String, String> request) {
        String question = request.get("question");
        String reply = chatbotService.autoReply(question);

        Map<String, String> response = new HashMap<>();
        response.put("reply", reply); // ✅ 반드시 key는 "reply"여야 함
        return response;
    }

}

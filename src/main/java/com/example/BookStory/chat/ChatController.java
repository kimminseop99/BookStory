package com.example.BookStory.chat;


import com.example.BookStory.user.entity.SiteUser;
import com.example.BookStory.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final UserService userService;
    @GetMapping("/chat/index")
    public String chatbotPage(Model model, Principal principal)
    {
        SiteUser user = userService.findByUsername(principal.getName());
        model.addAttribute("username", user.getUsername());
        return "chat/index";
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        chatMessage.setSentAt(java.time.LocalDateTime.now());
        return chatMessage;
    }
}

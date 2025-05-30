package com.example.BookStory.chatbot.util;

import java.util.HashMap;
import java.util.Map;

public class KeywordMatcher {
    private static final Map<String, String> faqMap = new HashMap<>();

    static {
        faqMap.put("비밀번호", "비밀번호는 마이페이지 > 비밀번호 변경에서 수정하실 수 있어요.");
        faqMap.put("독후감", "독후감은 독후감 페이지에서 작성하실 수 있으며 비밀글을 설정하면 작성자에게만 내용이 보여집니다.");
        faqMap.put("탈퇴", "회원 탈퇴는 마이페이지 > 회원정보 > 회원 탈퇴에서 가능합니다.");
    }


    public static String findMatch(String question) {
        if (question == null) return "질문이 비어 있어요.";
        return faqMap.entrySet().stream()
                .filter(entry -> question.contains(entry.getKey()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse("죄송해요, 이해하지 못했어요. 상담사 연결을 원하시면 실시간 채팅 상담을 이용해 주세요.");
    }
}

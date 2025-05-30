package com.example.BookStory.support.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupportController {

    @GetMapping("/support/index")
    public String supportIndex() {
        return "support/index"; // templates/support/index.html 파일을 렌더링함
    }
}

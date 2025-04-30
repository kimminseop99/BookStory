package com.example.BookStory.Main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/bookstory")
    @ResponseBody
    public String index() {
        return "안녕하세요 민섭입니다.";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}

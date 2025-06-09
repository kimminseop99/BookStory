package com.example.BookStory.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/info")
public class infoController {

    @GetMapping("/company")
    public String companyInfoPage() {
        return "info/company";
    }

    @GetMapping("/terms")
    public String termsOfServicePage() {
        return "info/terms";
    }

    @GetMapping("/privacy")
    public String privacyPolicyPage() {
        return "info/privacy";
    }
}

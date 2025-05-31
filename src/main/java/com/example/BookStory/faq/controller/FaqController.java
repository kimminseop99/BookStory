package com.example.BookStory.faq.controller;

import com.example.BookStory.faq.service.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/faq")
public class FaqController {
    private final FaqService faqService;

    @GetMapping("/list")
    public String listFaqs(Model model) {
        model.addAttribute("faqList", faqService.getAllFaqs());
        return "faq/list";
    }

    @GetMapping("/view/{id}")
    public String viewFaq(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("faq", faqService.getFaq(id));
        return "faq/view";
    }
}

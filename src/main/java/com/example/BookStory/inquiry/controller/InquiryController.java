package com.example.BookStory.inquiry.controller;

import com.example.BookStory.inquiry.entity.Inquiry;
import com.example.BookStory.inquiry.service.InquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/inquiry")
public class InquiryController {
    private final InquiryService inquiryService;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("inquiry", new Inquiry());
        return "inquiry/form";
    }

    @PostMapping("/form")
    public String submitForm(@ModelAttribute Inquiry inquiry) {
        inquiryService.saveInquiry(inquiry);
        return "redirect:/inquiry/my";
    }

    @GetMapping("/my")
    public String myInquiries(Model model) {
        model.addAttribute("inquiries", inquiryService.getAllInquiries());
        return "inquiry/my";
    }

    @GetMapping("/view/{id}")
    public String viewInquiry(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("inquiry", inquiryService.getInquiry(id));
        return "inquiry/view";
    }
}

package com.example.BookStory.bookReview.controller;

import com.example.BookStory.bookReview.dto.BookReviewForm;
import com.example.BookStory.bookReview.entity.BookReview;
import com.example.BookStory.bookReview.service.BookReviewService;
import com.example.BookStory.user.entity.SiteUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class BookReviewController {

    private final BookReviewService bookReviewService;

    // 리뷰 목록 페이지
    @GetMapping("list")
    public String list(Model model) {
        model.addAttribute("reviewList", bookReviewService.findAll());
        return "reviews/list";
    }

    // 독후감 작성 폼
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("bookReviewForm", new BookReviewForm());
        return "reviews/form";
    }

    // 독후감 등록 처리
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute BookReviewForm bookReviewForm,
                         BindingResult bindingResult,
                         @AuthenticationPrincipal UserDetails userDetails) {
        if (bindingResult.hasErrors()) {
            return "reviews/form";
        }

        SiteUser writer = new SiteUser();
        writer.setUsername(userDetails.getUsername());

        bookReviewService.create(
                bookReviewForm.getTitle(),
                bookReviewForm.getContent(),
                bookReviewForm.isSecret(),
                writer
        );

        return "redirect:/reviews";
    }

    // 상세보기
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        Optional<BookReview> reviewOpt = bookReviewService.findById(id);
        if (reviewOpt.isEmpty()) {
            return "redirect:/reviews";  // 경로 오류 수정 (리뷰 목록 경로 통일)
        }

        model.addAttribute("review", reviewOpt.get());
        return "reviews/detail";
    }

    // 독후감 수정 폼
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model,
                           @AuthenticationPrincipal UserDetails userDetails) {
        Optional<BookReview> reviewOpt = bookReviewService.findById(id);
        if (reviewOpt.isEmpty()) {
            return "redirect:/reviews";
        }

        BookReview review = reviewOpt.get();
        if (!review.getWriter().getUsername().equals(userDetails.getUsername())) {
            return "redirect:/reviews";
        }

        BookReviewForm form = new BookReviewForm();
        form.setTitle(review.getTitle());
        form.setContent(review.getContent());
        form.setSecret(review.isSecret());

        model.addAttribute("bookReviewForm", form);
        model.addAttribute("reviewId", id);
        return "reviews/edit-form";
    }

    // 독후감 수정 처리
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id,
                       @Valid @ModelAttribute BookReviewForm bookReviewForm,
                       BindingResult bindingResult,
                       @AuthenticationPrincipal UserDetails userDetails) {
        if (bindingResult.hasErrors()) {
            return "reviews/edit-form";
        }

        Optional<BookReview> reviewOpt = bookReviewService.findById(id);
        if (reviewOpt.isEmpty()) {
            return "redirect:/reviews";
        }

        BookReview review = reviewOpt.get();
        if (!review.getWriter().getUsername().equals(userDetails.getUsername())) {
            return "redirect:/reviews";
        }

        bookReviewService.update(review, bookReviewForm.getTitle(), bookReviewForm.getContent(), bookReviewForm.isSecret());
        return "redirect:/reviews/detail/" + id;
    }

    // 독후감 삭제 처리
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id,
                         @AuthenticationPrincipal UserDetails userDetails) {
        Optional<BookReview> reviewOpt = bookReviewService.findById(id);
        if (reviewOpt.isEmpty()) {
            return "redirect:/reviews";
        }

        BookReview review = reviewOpt.get();
        if (!review.getWriter().getUsername().equals(userDetails.getUsername())) {
            return "redirect:/reviews";
        }

        bookReviewService.delete(review);
        return "redirect:/reviews";
    }
}

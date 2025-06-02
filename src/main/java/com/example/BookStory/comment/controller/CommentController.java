package com.example.BookStory.comment.controller;

import com.example.BookStory.bookReview.entity.BookReview;
import com.example.BookStory.bookReview.service.BookReviewService;
import com.example.BookStory.comment.dto.CommentForm;
import com.example.BookStory.comment.entity.Comment;
import com.example.BookStory.comment.service.CommentService;
import com.example.BookStory.user.entity.SiteUser;
import com.example.BookStory.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;
    private final BookReviewService bookReviewService;
    private final UserService userService;

    @PostMapping("/create/{id}")
    public String createComment(@PathVariable("id") Long reviewId,
                                @Valid @ModelAttribute CommentForm commentForm,
                                BindingResult bindingResult,
                                Principal principal) {

        Optional<BookReview> reviewOpt = bookReviewService.findById(reviewId);
        if (reviewOpt.isEmpty()) return "redirect:/reviews/list";

        if (bindingResult.hasErrors()) {
            return "redirect:/reviews/detail" + reviewId; // 임시
        }

        SiteUser writer = userService.getUser(principal.getName());
        commentService.create(commentForm.getContent(), writer, reviewOpt.get());

        return "redirect:/reviews/detail/" + reviewId;
    }

    @PostMapping("/delete/{id}")
    public String deleteComment(@PathVariable("id") Long commentId,
                                @AuthenticationPrincipal UserDetails userDetails) {
        Optional<Comment> commentOpt = commentService.findById(commentId);
        if (commentOpt.isEmpty()) return "redirect:/reviews/detail";

        Comment comment = commentOpt.get();
        if (!comment.getWriter().getUsername().equals(userDetails.getUsername())) {
            return "redirect:/reviews/detail";
        }

        commentService.delete(comment);
        return "redirect:/reviews/detail/" + comment.getBookReview().getId();
    }

}
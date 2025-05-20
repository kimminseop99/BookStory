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

    @PostMapping("/create/{reviewId}")
    public String createComment(@PathVariable Long reviewId,
                                @Valid @ModelAttribute CommentForm commentForm,
                                BindingResult bindingResult,
                                @AuthenticationPrincipal UserDetails userDetails) {

        Optional<BookReview> reviewOpt = bookReviewService.findById(reviewId);
        if (reviewOpt.isEmpty()) return "redirect:/reviews";

        if (bindingResult.hasErrors()) {
            return "redirect:/reviews/" + reviewId; // 임시
        }

        SiteUser writer = new SiteUser();
        writer.setUsername(userDetails.getUsername());

        commentService.create(commentForm.getContent(), writer, reviewOpt.get());

        return "redirect:/reviews/" + reviewId;
    }

    @PostMapping("/delete/{commentId}")
    public String deleteComment(@PathVariable Long commentId,
                                @AuthenticationPrincipal UserDetails userDetails) {
        Optional<Comment> commentOpt = commentService.findById(commentId);
        if (commentOpt.isEmpty()) return "redirect:/reviews";

        Comment comment = commentOpt.get();
        if (!comment.getWriter().getUsername().equals(userDetails.getUsername())) {
            return "redirect:/reviews";
        }

        commentService.delete(comment);
        return "redirect:/reviews/" + comment.getBookReview().getId();
    }

    @GetMapping("/edit/{commentId}")
    public String editCommentForm(@PathVariable Long commentId, Model model, @AuthenticationPrincipal UserDetails userDetails) {
        Optional<Comment> commentOpt = commentService.findById(commentId);
        if (commentOpt.isEmpty()) return "redirect:/reviews";

        Comment comment = commentOpt.get();
        if (!comment.getWriter().getUsername().equals(userDetails.getUsername())) {
            return "redirect:/reviews";
        }

        model.addAttribute("commentForm", new CommentForm());
        model.addAttribute("commentId", commentId);
        return "comment/edit-form"; // 댓글 수정 폼을 위한 뷰
    }

    @PostMapping("/edit/{commentId}")
    public String editComment(@PathVariable Long commentId,
                              @Valid @ModelAttribute CommentForm commentForm,
                              BindingResult bindingResult,
                              @AuthenticationPrincipal UserDetails userDetails) {
        if (bindingResult.hasErrors()) {
            return "redirect:/reviews/" + commentId;
        }

        Optional<Comment> commentOpt = commentService.findById(commentId);
        if (commentOpt.isEmpty()) return "redirect:/reviews";

        Comment comment = commentOpt.get();
        if (!comment.getWriter().getUsername().equals(userDetails.getUsername())) {
            return "redirect:/reviews";
        }

        commentService.update(comment, commentForm.getContent());
        return "redirect:/reviews/" + comment.getBookReview().getId();
    }

}
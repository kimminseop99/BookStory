package com.example.BookStory.user.controller;

import com.example.BookStory.book.entity.Book;
import com.example.BookStory.book.service.BookService;
import com.example.BookStory.bookReview.entity.BookReview;
import com.example.BookStory.bookReview.service.BookReviewService;
import com.example.BookStory.user.entity.SiteUser;
import com.example.BookStory.user.form.UserCreateForm;
import com.example.BookStory.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final BookReviewService bookReviewService;

    @GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm) {
        return "user/signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("alertMessage", "입력값을 확인해주세요.");
            return "user/signup_form";
        }

        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect", "2개의 패스워드가 일치하지 않습니다.");
            model.addAttribute("alertMessage", "2개의 패스워드가 일치하지 않습니다.");
            return "user/signup_form";
        }

        try {
            userService.create(userCreateForm.getUsername(),
                    userCreateForm.getEmail(), userCreateForm.getPassword1());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            model.addAttribute("alertMessage", "이미 등록된 사용자입니다.");
            return "user/signup_form";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            model.addAttribute("alertMessage", "회원가입 중 오류가 발생했습니다: " + e.getMessage());
            return "user/signup_form";
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login_form";
    }

    @GetMapping("/find-password")
    public String showFindPasswordForm() {
        return "user/find_password_form";
    }


    @PostMapping("/find-password")
    public String processFindPassword(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            Model model)
    {
        SiteUser user = userService.findByUsernameAndEmail(username, email);
        if (user == null) {
            model.addAttribute("errorMessage", "해당 사용자 정보를 찾을 수 없습니다.");
            return "user/find_password_form";
        }
        // 비밀번호 재설정 폼으로 사용자 ID 넘기기
        model.addAttribute("username", user.getUsername());
        return "user/reset_password_form";
    }

    @PostMapping("/reset-password")
    public String resetPassword(
            @RequestParam("username") String username,
            @RequestParam("password1") String password1,
            @RequestParam("password2") String password2,
            Model model) {
        if (!password1.equals(password2)) {
            model.addAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
            model.addAttribute("username", username);
            return "user/reset_password_form";
        }

        try {
            userService.updatePassword(username, password1);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "비밀번호 변경 중 오류 발생: " + e.getMessage());
            return "user/reset_password_form";
        }

        return "redirect:/user/login?resetSuccess";
    }

    @GetMapping("/mypage")
    public String myPage(Model model, Principal principal) {
        SiteUser user = userService.getUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "user/mypage";
    }

    @GetMapping("/change-password")
    public String changePasswordForm() {
        return "user/change_password";
    }

    @PostMapping("/change-password")
    public String changePassword(@RequestParam("oldPassword") String oldPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 Principal principal,
                                 RedirectAttributes redirectAttributes) {
        try {
            if(oldPassword.equals(newPassword)){
                redirectAttributes.addFlashAttribute("errorMessage", "바꾸실려는 비밀번호가 기존 비밀번호와 동일합니다.");
                return "redirect:/user/change-password";
            }
            userService.changePassword(principal.getName(), oldPassword, newPassword);
            redirectAttributes.addFlashAttribute("successMessage", "비밀번호가 변경되었습니다.");
            return "redirect:/user/mypage";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/user/change-password";
        }
    }

    @GetMapping("/my-reviews")
    public String myReviews(Model model, Principal principal) {
        SiteUser user = userService.getUserByUsername(principal.getName());
        List<BookReview> myReviews = bookReviewService.getReviewsByUser(user);
        model.addAttribute("myReviews", myReviews);
        return "user/my_reviews";
    }

}


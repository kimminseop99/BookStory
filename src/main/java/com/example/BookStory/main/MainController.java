package com.example.BookStory.main;


import com.example.BookStory.book.entity.Book;
import com.example.BookStory.book.service.BookService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final BookService bookService;


    @GetMapping("/")
    public String root() {
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String showMainPage(Model model) {
        List<Book> recommendedBooks = bookService.findByPersonalRecommendationTrue();
        model.addAttribute("recommendedBooks", recommendedBooks);

        List<Book> allBooks = bookService.findAllBooks();
        List<Book> fictionBooks = bookService.findByCategory("소설");
        List<Book> selfHelpBooks = bookService.findByCategory("자기계발");
        List<Book> scienceBooks = bookService.findByCategory("과학");
        List<Book> computerBooks = bookService.findByCategory("컴퓨터");

        model.addAttribute("bookList", allBooks);
        model.addAttribute("fictionBooks", fictionBooks);
        model.addAttribute("selfHelpBooks", selfHelpBooks);
        model.addAttribute("scienceBooks", scienceBooks);
        model.addAttribute("computerBooks", computerBooks);
        return "main"; // src/main/resources/templates/main.html
    }



}

package com.example.BookStory.main;


import com.example.BookStory.book.entity.Book;
import com.example.BookStory.book.service.BookService;
import com.example.BookStory.search.BookDto;
import com.example.BookStory.search.NaverBookApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final BookService bookService;
    private final NaverBookApiService naverBookApiService;

    @GetMapping("/")
    public String root() {
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String showMainPage(Model model) {
        List<Book> bookList = bookService.getTopBooks(); // 원하는 리스트 (예: 인기순, 최신순 등)
        model.addAttribute("bookList", bookList);
        return "main"; // src/main/resources/templates/main.html
    }

    @GetMapping("/search")
    public String searchBook(@RequestParam("query") String query, Model model) throws Exception {
        try {
            // 쿼리 파라미터가 UTF-8로 URL 인코딩되어 있는지 확인하고, 디코딩 처리
            String decodedQuery = URLDecoder.decode(query, StandardCharsets.UTF_8.name());
            model.addAttribute("searchQuery", decodedQuery); // ✅ 검색어 전달
            // NaverBookApiService에서 검색 결과 가져오기
            List<BookDto> bookList = naverBookApiService.searchBooks(decodedQuery);

            if (bookList.isEmpty()) {
                model.addAttribute("message", "검색된 책이 없습니다. 다른 검색어를 시도해보세요.");
            } else {
                model.addAttribute("books", bookList);
            }
        } catch (UnsupportedEncodingException e) {
            model.addAttribute("error", "검색어 디코딩 중 오류가 발생했습니다.");
        } catch (Exception e) {
            model.addAttribute("error", "검색 중 오류가 발생했습니다. 다시 시도해주세요.");
            e.printStackTrace();  // 디버깅용 예외 로그
        }
        return "search-result";  // 검색 결과 출력할 템플릿
    }

}

package com.example.BookStory.faq.service;

import com.example.BookStory.faq.entity.Faq;
import com.example.BookStory.faq.repository.FaqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaqService {
    private final FaqRepository faqRepository;

    public List<Faq> getAllFaqs() {
        return faqRepository.findAll();
    }

    public Faq getFaq(Long id) {
        return faqRepository.findById(id).orElse(null);
    }

    public Faq createFaq(Faq faq) {
        return faqRepository.save(faq);
    }
}


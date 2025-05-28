package com.example.BookStory.user.service;

import com.example.BookStory.book.entity.Book;
import com.example.BookStory.book.repository.BookRepository;
import com.example.BookStory.user.entity.SiteUser;
import com.example.BookStory.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String username, String email, String password) {
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }


    public SiteUser findByUsernameAndEmail(String username, String email) {
        return (SiteUser) userRepository.findByUsernameAndEmail(username, email)
                .orElse(null);
    }

    @Transactional
    public void updatePassword(String username, String newPassword) {
        SiteUser user = (SiteUser) userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    public SiteUser findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }


    public void changePassword(String username, String oldPassword, String newPassword) {
        SiteUser user = findByUsername(username);
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new IllegalArgumentException("기존 비밀번호가 일치하지 않습니다.");
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }


}

package com.example.BookStory.user.repository;


import com.example.BookStory.user.entity.SiteUser;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Long> {
    Optional<SiteUser> findByusername(String username);

    Optional<Object> findByUsernameAndEmail(String username, String email);

    <T> Optional<T> findByUsername(String username);
}

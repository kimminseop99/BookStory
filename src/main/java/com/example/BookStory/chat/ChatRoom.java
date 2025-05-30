package com.example.BookStory.chat;

import com.example.BookStory.user.entity.SiteUser;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ChatRoom {
    @Id
    private String id;
    private String name;
    private boolean active;

    @ManyToOne
    private SiteUser customer;
}


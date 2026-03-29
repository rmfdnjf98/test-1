package com.example.javatest;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Guestbook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String content;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Guestbook(String author, String content, LocalDateTime createdAt) {
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
    }
}

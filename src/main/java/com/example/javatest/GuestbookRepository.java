package com.example.javatest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long> {

    List<Guestbook> findAllByOrderByCreatedAtDesc();
}

package com.example.javatest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long> {

    @Query("select g from Guestbook g order by g.id desc")
    List<Guestbook> findAllOrderByIdDesc();
}

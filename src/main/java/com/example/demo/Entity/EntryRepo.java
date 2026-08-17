package com.example.demo.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntryRepo extends JpaRepository<Entry, Long> {
    List<Entry> findByName(String name);
}

package org.example.webul.week9jpa.repository;

import org.example.webul.week9jpa.entity.movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface movierepository extends JpaRepository<movie, Long> {
}

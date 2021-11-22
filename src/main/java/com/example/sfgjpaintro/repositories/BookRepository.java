package com.example.sfgjpaintro.repositories;

import com.example.sfgjpaintro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

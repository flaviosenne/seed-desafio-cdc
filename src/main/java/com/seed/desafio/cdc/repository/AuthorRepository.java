package com.seed.desafio.cdc.repository;

import com.seed.desafio.cdc.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, String> {
    Optional<Object> findByEmail(String email);
}

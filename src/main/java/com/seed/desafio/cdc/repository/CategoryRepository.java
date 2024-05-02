package com.seed.desafio.cdc.repository;

import com.seed.desafio.cdc.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, String> {
}

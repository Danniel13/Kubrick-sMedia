package com.dani.dev.videotienda.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dani.dev.videotienda.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String string); //LISTAR TODAS LAS CATEGORIAS
    
}

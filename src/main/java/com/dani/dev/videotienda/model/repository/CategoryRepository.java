package com.dani.dev.videotienda.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dani.dev.videotienda.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    
}

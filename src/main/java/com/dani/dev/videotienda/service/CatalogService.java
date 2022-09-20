package com.dani.dev.videotienda.service;

import java.util.List;
import java.util.Optional;

import com.dani.dev.videotienda.Controller.dto.CategoryDto;
import com.dani.dev.videotienda.Controller.dto.MovieDto;

public interface CatalogService {

    List<CategoryDto> getCategories();

    Optional<CategoryDto> getCategoryById(Integer id);

    List<MovieDto> getMoviesByCategoryId(Integer categoryId);
}

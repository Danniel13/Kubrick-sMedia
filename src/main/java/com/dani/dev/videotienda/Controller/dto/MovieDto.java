package com.dani.dev.videotienda.Controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private Integer id;
    private String name;
    private Integer categoryId;
    private String description;
    private String length;
    private String imageUrl;  
}

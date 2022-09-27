package com.dani.dev.videotienda.model.entity;


import javax.persistence.Column;
// JPA
import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    private Long code;
    
    private String name;
    @Column(name = "description",  length = 500)
    private String description;
    private Integer length;
    private String imageUrl;

    @ManyToOne
    private Category category;
}

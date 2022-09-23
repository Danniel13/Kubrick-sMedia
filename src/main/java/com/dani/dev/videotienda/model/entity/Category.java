package com.dani.dev.videotienda.model.entity;

import java.util.List;

import javax.persistence.Entity;
import lombok.Data;
@Entity
@Data //Importa set & get de los atributos.
public class Category {
  private String name;

  private List<Movie> movies; //Relacion una categoria a muchas peliculas
}

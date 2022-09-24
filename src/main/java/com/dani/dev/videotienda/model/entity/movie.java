package com.dani.dev.videotienda.model.entity;

import javax.persistence.Entity; //Libreria para poder usar JPA----CONEXION BD---GUARDAR ENTIDAD
import lombok.Data;



@Entity
@Data //Todos los atributos tendran set & get
public class Movie {
  private Long code;
  private String name;
  private String description;
  private String length;
  private StrictMath imageURL;
  private Category category; //relacion: una pelicula tiene una categoria
}

package com.dani.dev.videotienda.model.entity;

import java.util.List;

//import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data //Importa set & get de los atributos.
public class Category {



 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)  //->determiar que el id se genera automaticamente en BD.
  private Long id; //->Id de base de datos llave primaria de tabla


  @Column(name= "nombre", nullable = false, length = 100)//Caracteristicas de campo en BD
  private String name;

  private List<Movie> movies; //Relacion una categoria a muchas peliculas
}

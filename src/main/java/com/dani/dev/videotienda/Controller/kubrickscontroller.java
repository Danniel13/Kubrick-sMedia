package com.dani.dev.videotienda.Controller;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dani.dev.videotienda.Controller.dto.CategoryDto;
import com.dani.dev.videotienda.Controller.dto.MovieDto;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class kubrickscontroller {
  // GET MAPPING CON LA FUNCION GO CATALOG: REALIZA TODO EL AJUSTE DE LA REDIRECCION DE FORMS EN LA PAGINA
  //MODEL: SPRING MVC--REPRESENTA LOS DATOS QUE SE VAN A ENVIAR A LA VISTA PARA QUE SE MUESTRE LA INFORMACIÓN
  private final List<CategoryDto> categories = Arrays.asList(
    new CategoryDto("Action", 1),
    new CategoryDto("Comedy", 2),
    new CategoryDto("Romance", 3),
    new CategoryDto("Sci-fi", 4));

private final List<MovieDto> movies = Arrays.asList(
    new MovieDto(1, "The Matrix", 4,
            "Cuando una bella desconocida lleva al hacker Neo a un inframundo prohibido, descubre la impactante verdad: la vida que conoce es un elaborado engaño de una ciberinteligencia malvada.",
            120, null),
    new MovieDto(2, "Dumb and Dumber", 2, "Esta pelicula trata de ..", 90, null),
    new MovieDto(2, "Dumb and Dumber", 2,
            "Cuando una bella desconocida lleva al hacker Neo a un inframundo prohibido, descubre la impactante verdad: la vida que conoce es un elaborado engaño de una ciberinteligencia malvada.",
            90, null),
    new MovieDto(2, "Dumb and Dumber", 2, "Esta pelicula trata de ..", 90, null),
    new MovieDto(2, "Dumb and Dumber", 2, "Esta pelicula trata de ..", 90, null),
    new MovieDto(2, "Dumb and Dumber", 2, "Esta pelicula trata de ..", 90, null));

  @GetMapping("/catalog" )
  public String goToCatalog(Model model){  //Model es la forma como se va a enviar desde backend al html

    model.addAttribute("categories", categories);
    return "catalog";
  }

  @GetMapping("/catalog/{id}")
  public String loadCatalogById(@PathVariable("id") Integer id, Model model) {
      log.info("Cargando informacion de categoria {}", id);

      var category = categories.stream()
              .filter(c -> c.getId().equals(id))
              .findFirst()
              .orElseThrow(() -> new RuntimeException("La categoria no existe"));

      model.addAttribute("title", category.getName());
      model.addAttribute("id", category.getId());
      model.addAttribute("categories", categories);

      var categoryMovies = movies.stream()
              .filter(m -> m.getCategoryId().equals(id))
              .collect(Collectors.toList());

      model.addAttribute("movies", categoryMovies);

      return "catalog";
  }

  @GetMapping("/Contact" )
  public String goTocontact2(Model model){  //Model es la forma como se va a enviar desde backend al html
    return "Contact";
  } 


  @GetMapping("/login" )
  public String goTologin(Model model){  //Model es la forma como se va a enviar desde backend al html
    return "login";
  }


}
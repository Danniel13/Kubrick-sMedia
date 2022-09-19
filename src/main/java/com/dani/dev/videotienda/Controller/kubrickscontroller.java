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
    new CategoryDto("Belic", 2),
    new CategoryDto("Comedy", 3),
    new CategoryDto("Awarderds", 4),
    new CategoryDto("Classic", 5));

private final List<MovieDto> movies = Arrays.asList(

//Category 1:
    new MovieDto(1, "Spider-Man: No Way Home", 1,
            "Spider-Man seeks the help of Doctor Strange to forget his exposed secret identity as Peter Parker. However, Strange's spell goes horribly wrong, leading to unwanted guests entering their universe.",
            "2h 20m", "/img/movies/spid.jpeg"),
    new MovieDto(2, "Fast & Furious: Hobbs & Shaw", 1, "US agent Luke Hobbs and British mercenary Deckard Shaw are forced to put their rivalry side and work together to stop a genetically enhanced supervillain that after to manu time is an insencible person.", "2h 15m", "/img/movies/fastfurious.jpg"),
    new MovieDto(3, "Top Gun: Maverick", 1, "Film directed by Joseph Kosinski. It is the sequel to the 1986 film Top Gun and the second installment in the Top Gun film series. Written by Ehren Kruger, Eric Warren Singer, and Christopher McQuarrie, the film is based on a story by Peter Craig and Justin Marks.", "2h 10m", "/img/movies/top.jpg"),
    new MovieDto(4, "Dumb and Dumber", 1, "Esta pelicula trata de ..", "90", null),
    
 //Category 2:

    new MovieDto(5, "Dumb and Dumber", 2,
            "Cuando una bella desconocida lleva al hacker Neo a un inframundo prohibido, descubre la impactante verdad: la vida que conoce es un elaborado engaño de una ciberinteligencia malvada.",
            "90", null),
    new MovieDto(6, "Dumb and Dumber", 2, "Esta pelicula trata de ..", "90", null));

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
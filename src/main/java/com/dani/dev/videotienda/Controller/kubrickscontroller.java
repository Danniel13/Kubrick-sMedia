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
  // GET MAPPING CON LA FUNCION GO CATALOG: REALIZA TODO EL AJUSTE DE LA
  // REDIRECCION DE FORMS EN LA PAGINA
  // MODEL: SPRING MVC--REPRESENTA LOS DATOS QUE SE VAN A ENVIAR A LA VISTA PARA
  // QUE SE MUESTRE LA INFORMACIÓN
  private final List<CategoryDto> categories = Arrays.asList(
      new CategoryDto("Action", 1),
      new CategoryDto("Belic", 2),
      new CategoryDto("Comedy", 3),
      new CategoryDto("Awarderds", 4),
      new CategoryDto("Classic", 5));

  private final List<MovieDto> movies = Arrays.asList(

      // Category 1:
      new MovieDto(1, "Spider-Man: No Way Home", 1,
          "Spider-Man seeks the help of Doctor Strange to forget his exposed secret identity as Peter Parker. However, Strange's spell goes horribly wrong, leading to unwanted guests entering their universe.",
          "2h 20m", "/img/movies/spid.jpeg"),
      new MovieDto(2, "Fast & Furious: Hobbs & Shaw", 1,
          "US agent Luke Hobbs and British mercenary Deckard Shaw are forced to put their rivalry side and work together to stop a genetically enhanced supervillain that after to manu time is an insencible person.",
          "2h 15m", "/img/movies/fastfurious.jpg"),
      new MovieDto(3, "Top Gun: Maverick", 1,
          "Film directed by Joseph Kosinski. It is the sequel to the 1986 film Top Gun and the second installment in the Top Gun film series. Written by Ehren Kruger, Eric Warren Singer, and Christopher McQuarrie, the film is based on a story by Peter Craig and Justin Marks.",
          "2h 10m", "/img/movies/top.jpg"),
      new MovieDto(4, "Memory", 1,
          "Memory is a 2022 American action thriller film directed by Martin Campbell from a screenplay by Dario Scardapane. It is based on the novel De Zaak Alzheimer by Jef Geeraerts and is a remake of the novel's previous adaptation, the Belgian film The Alzheimer Case.",
          "1h 53m", "/img/movies/memory.jpg"),

      // Category 2:

      new MovieDto(5, "Greyhound", 2,
          "Greyhound is a 2020 American war film directed by Aaron Schneider and starring Tom Hanks, who also wrote the screenplay. The film is based on the 1955 novel The Good Shepherd by C. S. Forester, and also stars Stephen Graham, Rob Morgan, and Elisabeth Shue.",
          "1h 31m", "/img/movies/greyhound.jpg"),

      new MovieDto(6, "Operation Mincemeat", 2,
          "Operation Mincemeat is a 2021 British war drama film directed by John Madden. It is based upon Ben Macintyre's book on the British Operation Mincemeat during the Second World War. The film stars Colin Firth, Kelly Macdonald, Matthew Macfadyen, Penelope Wilton, Johnny Flynn and Jason Isaacs.",
          "2h 7m", "/img/movies/mincemeat.jpg"),

      new MovieDto(7, "Dunkirk", 2,
          "Dunkirk is a 2017 war film written, directed, and produced by Christopher Nolan that depicts the Dunkirk evacuation of World War II through the perspectives of the land, sea, and air. During World War II, soldiers from the British Empire, Belgium and France try to evacuate from the town of Dunkirk.",
          "2h 17m", "/img/movies/dunkir.jpg"),

      // Category 3:

      new MovieDto(8, "Dog", 3,
          "Dog is a 2022 American comedy drama road film directed by Channing Tatum and Reid Carolin, both making their respective film directorial debuts, based on a story by Carolin and Brett Rodriguez. The film stars Tatum as an Army Ranger who is tasked with escorting the military dog of his fallen friend to his funeral.",
          "1h 37m", "/img/movies/dog.jpg"),
      new MovieDto(8, "The Addams Family", 3,
      "The Addams Family is a fictional family created by American cartoonist Charles Addams. They originally appeared in a series of 150 unrelated single-panel cartoons, about half of which were originally published in The New Yorker over a 50-year period from their inception in 1938. This movie is an adaptation to Adams.",
      "1h 39m", "/img/movies/adams.jpg"),
      new MovieDto(8, "The Hangover 1", 3,
      "The plot of The Hangover was inspired by a real event that happened to Tripp Vinson, a producer and friend of executive producer Chris Bender. Vinson had gone missing from his own Las Vegas bachelor party, blacking out and waking up in a strip club being threatened with a very, very large bill I was supposed to pay ",
      "1h 39m", "/img/movies/hangover.jpg"));

  @GetMapping("/catalog")
  public String goToCatalog(Model model) { // Model es la forma como se va a enviar desde backend al html

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

  @GetMapping("/Contact")
  public String goTocontact2(Model model) { // Model es la forma como se va a enviar desde backend al html
    return "Contact";
  }

  @GetMapping("/login")
  public String goTologin(Model model) { // Model es la forma como se va a enviar desde backend al html
    return "login";
  }

}
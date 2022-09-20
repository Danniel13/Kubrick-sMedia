package com.dani.dev.videotienda.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dani.dev.videotienda.service.CatalogService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class kubrickscontroller {
  // GET MAPPING CON LA FUNCION GO CATALOG: REALIZA TODO EL AJUSTE DE LA
  // REDIRECCION DE FORMS EN LA PAGINA
  // MODEL: SPRING MVC--REPRESENTA LOS DATOS QUE SE VAN A ENVIAR A LA VISTA PARA
  // QUE SE MUESTRE LA INFORMACIÓN
 
  private CatalogService CatalogService;

  public kubrickscontroller(CatalogService CatalogService) {
      this.CatalogService = CatalogService;
  }

  @GetMapping("/catalog")
  public String goToCatalog(Model model) { // Model es la forma como se va a enviar desde backend al html

    var categories = this.CatalogService.getCategories();

    model.addAttribute("title", "Welcome to my site");
    model.addAttribute("categories", categories);

    return "catalog";
}

@GetMapping("/catalog/{id}")
public String loadCatalogById(@PathVariable("id") Integer id, Model model) {
    log.info("Cargando informacion de categoria {}", id);

    var categories = CatalogService.getCategories();
    model.addAttribute("categories", categories);

    var categoryOp = this.CatalogService.getCategoryById(id);
    if (categoryOp.isEmpty()) {
        // Mostrar mensaje de error
        model.addAttribute("error", "La categoria no existe");
    } else {
        var category = categoryOp.get();

        model.addAttribute("title", category.getName());
        model.addAttribute("id", category.getId());

        var categoryMovies = this.CatalogService.getMoviesByCategoryId(id);

        model.addAttribute("movies", categoryMovies);
    }

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
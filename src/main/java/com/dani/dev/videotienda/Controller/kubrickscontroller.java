package com.dani.dev.videotienda.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class kubrickscontroller {
  // GET MAPPING CON LA FUNCION GO CATALOG: REALIZA TODO EL AJUSTE DE LA REDIRECCION DE FORMS EN LA PAGINA
  //MODEL: SPRING MVC--REPRESENTA LOS DATOS QUE SE VAN A ENVIAR A LA VISTA PARA QUE SE MUESTRE LA INFORMACIÓN
  @GetMapping("/catalog" )
  public String goToCatalog(Model model){  //Model es la forma como se va a enviar desde backend al html
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
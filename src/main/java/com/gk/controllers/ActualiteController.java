package com.gk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gk.entities.Actualite;
import com.gk.services.ActualiteService;

@RequestMapping("/actualites")
@RestController
@CrossOrigin("*")
public class ActualiteController {

  @Autowired
  ActualiteService actualiteService;

  @GetMapping
  public List<Actualite> getAllActualites() {
    return actualiteService.getAllActualites();
  }

  @PostMapping
  public Actualite addApropos(@RequestBody Actualite actualite) {
    return actualiteService.saveActualite(actualite);
  }

  @DeleteMapping("/{id}")
  public void deleteActualite(@PathVariable(name = "id") long id) {
    actualiteService.deleteActualite(id);
  }

  @GetMapping("/{id}")
  public Actualite getActualite(@PathVariable long id) {
    return actualiteService.getActualite(id);
  }

  @PutMapping("/")
  public Actualite updateActualite(@RequestBody Actualite actualite) {
    return actualiteService.saveActualite(actualite);
  }

}

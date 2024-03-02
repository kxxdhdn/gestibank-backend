package com.gk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gk.entities.Compte;
import com.gk.services.CompteService;

@RequestMapping("/comptes")
@RestController
@CrossOrigin("*")
public class CompteController {
  
  @Autowired
  CompteService compteService;

  @GetMapping
  public List<Compte> getAllComptes() {
    return compteService.comptes();
  }

  @PostMapping
  public Compte addCompte(@RequestBody Compte compte) {
    return compteService.saveCompte(compte);
  }

  @DeleteMapping("/{id}")
  public void deleteCompte(@PathVariable long id) {
    compteService.deleteCompte(id);
  }

  @GetMapping("/{id}")
  public Compte getCompte(@PathVariable long id) {
    return compteService.getCompte(id);
  }

  @PutMapping
  public Compte updateCompte(@RequestBody Compte compte) {
    return compteService.saveCompte(compte);
  }

}

package com.gk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gk.entities.Prestation;
import com.gk.services.PrestationService;

@RequestMapping("/prestations")
@RestController
@CrossOrigin("*")
public class PrestationController {

  @Autowired
  PrestationService prestationService;

  @GetMapping
  public List<Prestation> getAllPrestations() {
    return prestationService.prestations();
  }

  @PostMapping
  public Prestation addPrestation(@RequestBody Prestation prestation) {
    return prestationService.savePrestation(prestation);
  }

  @DeleteMapping("/{id}")
  public void deletePrestation(@PathVariable long id) {
    prestationService.deletePrestation(id);
  }

  @GetMapping("/{id}")
  public Prestation getPrestation(@PathVariable long id) {
    return prestationService.getPrestation(id);
  }

  @PutMapping
  public Prestation updatePrestation(
      @RequestBody Prestation prestation) {
    return prestationService.savePrestation(prestation);
  }

}

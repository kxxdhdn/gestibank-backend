package com.gk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gk.entities.Banque;
import com.gk.services.BanqueService;

@RequestMapping("/banques")
@RestController
@CrossOrigin("*")
public class BanqueController {

  @Autowired
  BanqueService banqueService;

  @GetMapping
  public List<Banque> getAllBanques() {
    return banqueService.banques();
  }

  @PostMapping
  public Banque addBanque(@RequestBody Banque banque) {
    return banqueService.saveBanque(banque);
  }

  @DeleteMapping("/{id}")
  public void deleteBanque(@PathVariable long id) {
    banqueService.deleteBanque(id);
  }

  @GetMapping("/{id}")
  public Banque getBanque(@PathVariable long id) {
    return banqueService.getBanque(id);
  }

  @PutMapping
  public Banque updateBanque(@RequestBody Banque banque) {
    return banqueService.saveBanque(banque);
  }

}

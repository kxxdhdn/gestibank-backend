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

  @GetMapping("/list")
  public List<Banque> getAllBanques() {
    return banqueService.banques();
  }

  @PostMapping("/list")
  public Banque addBanque(@RequestBody Banque banque) {
    return banqueService.saveBanque(banque);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteBanque(@PathVariable int id) {
    banqueService.deleteBanque(id);
  }

  @GetMapping("/update/{id}")
  public Banque getBanque(@PathVariable int id) {
    return banqueService.getBanque(id);
  }

  @PutMapping("/list")
  public Banque updateBanque(@RequestBody Banque banque) {
    return banqueService.saveBanque(banque);
  }

}

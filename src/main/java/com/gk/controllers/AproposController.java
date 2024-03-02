package com.gk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gk.entities.Apropos;
import com.gk.services.AproposService;

@RequestMapping("/apropos")
@RestController
@CrossOrigin("*")
public class AproposController {

  @Autowired
  AproposService aproposService;

  @GetMapping
  public List<Apropos> getAllApropos() {
    return aproposService.getAllapropos();
  }

  @PostMapping
  public Apropos addApropos(@RequestBody Apropos apropos) {
    return aproposService.saveApropos(apropos);
  }

  @DeleteMapping("/{id}")
  public void deleteApropos(@PathVariable(name = "id") long id) {
    aproposService.deleteApropos(id);
  }

  @GetMapping("/{id}")
  public Apropos getApropos(@PathVariable long id) {
    return aproposService.getApropos(id);
  }

  @PutMapping
  public Apropos updateApropos(@RequestBody Apropos apropos) {
    return aproposService.saveApropos(apropos);
  }

}

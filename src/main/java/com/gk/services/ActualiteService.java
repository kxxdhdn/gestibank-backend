package com.gk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.gk.entities.Actualite;
import com.gk.repositories.ActualiteRepository;

@Service
public class ActualiteService {

  @Autowired
  ActualiteRepository actualiteRepository;

  public List<Actualite> getAllActualites() {
    return (List<Actualite>) actualiteRepository.findAll();
  }

  public Actualite saveActualite(Actualite actualite) {
    return actualiteRepository.save(actualite);
  }

  public void deleteActualite(@PathVariable(name = "id") long id) {
    actualiteRepository.deleteById(id);
  }

  public Actualite getActualite(long id) {
    return actualiteRepository.findById(id).get();
  }

}

package com.gk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.entities.Compte;
import com.gk.repositories.CompteRepository;

@Service
public class CompteService {

  @Autowired
  CompteRepository compteRepository;

  public List<Compte> comptes() {
    return (List<Compte>) compteRepository.findAll();
  }

  public Compte saveCompte(Compte compte) {
    return compteRepository.save(compte);
  }

  public void deleteCompte(long id) {
    compteRepository.deleteById(id);
  }

  public Compte getCompte(long id) {
    return compteRepository.findById(id).get();
  }

}

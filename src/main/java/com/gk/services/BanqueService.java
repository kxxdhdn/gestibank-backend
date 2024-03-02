package com.gk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.entities.Banque;
import com.gk.repositories.BanqueRepository;

@Service
public class BanqueService {

  @Autowired
  BanqueRepository banqueRepository;

  public List<Banque> banques() {
    return (List<Banque>) banqueRepository.findAll();
  }

  public Banque saveBanque(Banque banque) {
    return banqueRepository.save(banque);
  }

  public void deleteBanque(long id) {
    banqueRepository.deleteById(id);
  }

  public Banque getBanque(long id) {
    return banqueRepository.findById(id).get();
  }

}

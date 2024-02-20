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

  public void deleteBanque(int idBanque) {
    banqueRepository.deleteById(idBanque);
  }

  public Banque getBanque(int idBanque) {
    return banqueRepository.findById(idBanque).get();
  }

}

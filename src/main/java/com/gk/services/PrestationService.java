package com.gk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.entities.Prestation;
import com.gk.repositories.PrestationRepository;

@Service
public class PrestationService {

  @Autowired
  PrestationRepository prestationRepository;

  public List<Prestation> prestations() {
    return (List<Prestation>) prestationRepository.findAll();
  }

  public Prestation savePrestation(Prestation prestation) {
    return prestationRepository.save(prestation);
  }

  public void deletePrestation(long idPrestation) {
    prestationRepository.deleteById(idPrestation);
  }

  public Prestation getPrestation(long idPrestation) {
    return prestationRepository.findById(idPrestation).get();
  }

}

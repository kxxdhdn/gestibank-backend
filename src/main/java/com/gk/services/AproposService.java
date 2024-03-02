package com.gk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.gk.entities.Apropos;
import com.gk.repositories.AproposRepository;

@Service
public class AproposService {

  @Autowired
  AproposRepository aproposRepository;

  public List<Apropos> getAllapropos() {
    return (List<Apropos>) aproposRepository.findAll();
  }

  public Apropos saveApropos(Apropos apropos) {
    return aproposRepository.save(apropos);
  }

  public void deleteApropos(@PathVariable(name = "id") long id) {
    aproposRepository.deleteById(id);
  }

  public Apropos getApropos(long id) {
    return aproposRepository.findById(id).get();
  }

}

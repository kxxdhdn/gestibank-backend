package com.gk.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gk.entities.Compte;

@Repository
public interface CompteRepository extends CrudRepository<Compte, Long> {

  List<Compte> findByProprietaire(String proprietaire);

}

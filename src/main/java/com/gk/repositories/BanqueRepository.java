package com.gk.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gk.entities.Banque;

@Repository
public interface BanqueRepository
    extends CrudRepository<Banque, Long> {

  List<Banque> findByNom(String nom);

}

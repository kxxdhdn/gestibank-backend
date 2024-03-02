package com.gk.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gk.entities.Actualite;

@Repository
public interface ActualiteRepository
    extends CrudRepository<Actualite, Long> {

}

package com.gk.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gk.entities.Prestation;

@Repository
public interface PrestationRepository
    extends CrudRepository<Prestation, Long> {

}

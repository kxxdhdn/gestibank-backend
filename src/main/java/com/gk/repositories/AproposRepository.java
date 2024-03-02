package com.gk.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gk.entities.Apropos;

@Repository
public interface AproposRepository
    extends CrudRepository<Apropos, Long> {

}

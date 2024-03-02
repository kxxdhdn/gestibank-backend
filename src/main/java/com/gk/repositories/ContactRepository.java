package com.gk.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gk.entities.Contact;

@Repository
public interface ContactRepository
    extends CrudRepository<Contact, Long> {

}

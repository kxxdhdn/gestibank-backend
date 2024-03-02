package com.gk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.entities.Contact;
import com.gk.repositories.ContactRepository;

@Service
public class ContactService {

  @Autowired
  ContactRepository contactRepository;

  public List<Contact> contacts() {
    return (List<Contact>) contactRepository.findAll();
  }

  public Contact saveContact(Contact contact) {
    return contactRepository.save(contact);
  }

  public void deleteContact(long id) {
    contactRepository.deleteById(id);
  }

  public Contact getContact(long id) {
    return contactRepository.findById(id).get();
  }

}

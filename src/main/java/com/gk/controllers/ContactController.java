package com.gk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gk.entities.Contact;
import com.gk.services.ContactService;

@RequestMapping("/contact")
@RestController
@CrossOrigin("*")
public class ContactController {

  @Autowired
  ContactService contactService;

  @GetMapping
  public List<Contact> getAllContacts() {
    return contactService.contacts();
  }

  @PostMapping
  public Contact addContact(@RequestBody Contact contact) {
    return contactService.saveContact(contact);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable long id) {
    contactService.deleteContact(id);
  }

  @GetMapping("/{id}")
  public Contact getContact(@PathVariable long id) {
    return contactService.getContact(id);
  }

  @PutMapping("/{id}")
  public Contact updateContact(@RequestBody Contact contact) {
    return contactService.saveContact(contact);
  }

}

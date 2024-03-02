package com.gk.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
public class Contact {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String nom;
  private String email;
  private String sujet;
  private String description;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dateCreation;

  @Override
  public String toString() {
    return "Contact [id=" + id + ", nom=" + nom + ", email=" + email
        + ", sujet=" + sujet + ", description=" + description
        + ", dateCreation=" + dateCreation + "]";
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSujet() {
    return sujet;
  }

  public void setSujet(String sujet) {
    this.sujet = sujet;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getDateCreation() {
    return dateCreation;
  }

  public void setDateCreation(LocalDate dateCreation) {
    this.dateCreation = dateCreation;
  }

  public Contact(long id, String nom, String email, String sujet,
      String description, LocalDate dateCreation) {
    super();
    this.id = id;
    this.nom = nom;
    this.email = email;
    this.sujet = sujet;
    this.description = description;
    this.dateCreation = dateCreation;
  }

  public Contact(String nom, String email, String sujet,
      String description, LocalDate dateCreation) {
    super();
    this.nom = nom;
    this.email = email;
    this.sujet = sujet;
    this.description = description;
    this.dateCreation = dateCreation;
  }

  public Contact() {
    super();
  }

}

package com.gk.entities;

import jakarta.persistence.*;

@Entity
public class Prestation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String libelle;
  private String description;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "Prestation [id=" + id + ", libelle=" + libelle
        + ", description=" + description + "]";
  }

  public Prestation(long id, String libelle, String description) {
    super();
    this.id = id;
    this.libelle = libelle;
    this.description = description;
  }

  public Prestation(String libelle, String description) {
    super();
    this.libelle = libelle;
    this.description = description;
  }

  public Prestation() {
    super();
  }

}

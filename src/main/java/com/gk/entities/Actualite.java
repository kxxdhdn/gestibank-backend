package com.gk.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
public class Actualite {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String titre;
  private String description;
  private String logoImage;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dateCreation;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLogoImage() {
    return logoImage;
  }

  public void setLogoImage(String logoImage) {
    this.logoImage = logoImage;
  }

  public LocalDate getDateCreation() {
    return dateCreation;
  }

  public void setDateCreation(LocalDate dateCreation) {
    this.dateCreation = dateCreation;
  }

  @Override
  public String toString() {
    return "Actualite [id=" + id + ", titre=" + titre + ", description="
        + description + ", logoImage=" + logoImage + ", dateCreation="
        + dateCreation + "]";
  }

  public Actualite(long id, String titre, String description,
      String logoImage, LocalDate dateCreation) {
    super();
    this.id = id;
    this.titre = titre;
    this.description = description;
    this.logoImage = logoImage;
    this.dateCreation = dateCreation;
  }

  public Actualite(String titre, String description, String logoImage,
      LocalDate dateCreation) {
    super();
    this.titre = titre;
    this.description = description;
    this.logoImage = logoImage;
    this.dateCreation = dateCreation;
  }

  public Actualite() {
    super();
  }

}

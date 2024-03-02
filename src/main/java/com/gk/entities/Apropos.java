package com.gk.entities;

import jakarta.persistence.*;

@Entity
public class Apropos {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String telephone;
  private String email;
  private String adresse;
  private String description;
  private String logoImage;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
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

  @Override
  public String toString() {
    return "Apropos [id=" + id + ", telephone=" + telephone + ", email="
        + email + ", adresse=" + adresse + ", description="
        + description + ", logoImage=" + logoImage + "]";
  }

  public Apropos(long id, String telephone, String email,
      String adresse, String description, String logoImage) {
    super();
    this.id = id;
    this.telephone = telephone;
    this.email = email;
    this.adresse = adresse;
    this.description = description;
    this.logoImage = logoImage;
  }

  public Apropos(String telephone, String email, String adresse,
      String description, String logoImage) {
    super();
    this.telephone = telephone;
    this.email = email;
    this.adresse = adresse;
    this.description = description;
    this.logoImage = logoImage;
  }

  public Apropos() {
    super();
  }

}

package com.gk.models.response;

import java.time.LocalDate;
import java.util.List;

public class JwtResponse {

  private String token;
  private String type = "Bearer";
  private long id;
  private String username;
  private String email;
  private List<String> roles;
  private LocalDate dateCreation;
  private String nom;
  private String prenom;
  private String telephone;
  private String matricule;
  private String photo;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  public LocalDate getDateCreation() {
    return dateCreation;
  }

  public void setDateCreation(LocalDate dateCreation) {
    this.dateCreation = dateCreation;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getMatricule() {
    return matricule;
  }

  public void setMatricule(String matricule) {
    this.matricule = matricule;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public JwtResponse(String token, long id, String username,
      String email, List<String> roles, LocalDate dateCreation, String nom,
      String prenom, String telephone, String matricule, String photo) {
    super();
    this.token = token;
    this.id = id;
    this.username = username;
    this.email = email;
    this.roles = roles;
    this.dateCreation = dateCreation;
    this.nom = nom;
    this.prenom = prenom;
    this.telephone = telephone;
    this.matricule = matricule;
    this.photo = photo;
  }

}

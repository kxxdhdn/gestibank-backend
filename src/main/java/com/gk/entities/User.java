package com.gk.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = "username"),
    @UniqueConstraint(columnNames = "email") })
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NotBlank
  @Size(min = 3, max = 60)
  private String username;
  @Email
  @NotBlank
  @Size(max = 60)
  private String email;
  @NotBlank
  @Size(min = 6, max = 40)
  private String password;
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();
  private LocalDate dateCreation;
  private String nom;
  private String prenom;
  private String telephone;
  private String matricule;
  private String photo;

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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
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

  @Override
  public String toString() {
    return "User [id=" + id + ", username=" + username + ", email="
        + email + ", password=" + password + ", roles=" + roles
        + ", dateCreation=" + dateCreation + ", nom=" + nom
        + ", prenom=" + prenom + ", telephone=" + telephone
        + ", matricule=" + matricule + ", photo=" + photo + "]";
  }

  public User(long id,
      @NotBlank @Size(min = 3, max = 60) String username,
      @Email @NotBlank @Size(max = 60) String email,
      @NotBlank @Size(min = 6, max = 40) String password,
      Set<Role> roles, LocalDate dateCreation, String nom,
      String prenom, String telephone, String matricule, String photo) {
    super();
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.roles = roles;
    this.dateCreation = dateCreation;
    this.nom = nom;
    this.prenom = prenom;
    this.telephone = telephone;
    this.matricule = matricule;
    this.photo = photo;
  }

  public User(@NotBlank @Size(min = 3, max = 60) String username,
      @Email @NotBlank @Size(max = 60) String email,
      @NotBlank @Size(min = 6, max = 40) String password,
      Set<Role> roles, LocalDate dateCreation, String nom,
      String prenom, String telephone, String matricule, String photo) {
    super();
    this.username = username;
    this.email = email;
    this.password = password;
    this.roles = roles;
    this.dateCreation = dateCreation;
    this.nom = nom;
    this.prenom = prenom;
    this.telephone = telephone;
    this.matricule = matricule;
    this.photo = photo;
  }

  public User(@NotBlank @Size(min = 3, max = 60) String username,
      @Email @NotBlank @Size(max = 60) String email,
      @NotBlank @Size(min = 6, max = 40) String password) {
    super();
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public User() {
    super();
  }

}

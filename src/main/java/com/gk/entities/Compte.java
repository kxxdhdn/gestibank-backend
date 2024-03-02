package com.gk.entities;

import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
public class Compte {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String proprietaire;
  private String typeCompte;
  private double solde;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dateCreation;
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "banque_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Banque banque;

  @Override
  public String toString() {
    return "Compte [id=" + id + ", proprietaire=" + proprietaire
        + ", typeCompte=" + typeCompte + ", solde=" + solde
        + ", dateCreation=" + dateCreation + ", banque=" + banque + "]";
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getProprietaire() {
    return proprietaire;
  }

  public void setProprietaire(String proprietaire) {
    this.proprietaire = proprietaire;
  }

  public String getTypeCompte() {
    return typeCompte;
  }

  public void setTypeCompte(String typeCompte) {
    this.typeCompte = typeCompte;
  }

  public double getSolde() {
    return solde;
  }

  public void setSolde(double solde) {
    this.solde = solde;
  }

  public LocalDate getDateCreation() {
    return dateCreation;
  }

  public void setDateCreation(LocalDate dateCreation) {
    this.dateCreation = dateCreation;
  }

  public Banque getBanque() {
    return banque;
  }

  public void setBanque(Banque banque) {
    this.banque = banque;
  }

  public Compte(long id, String proprietaire, String typeCompte,
      double solde, LocalDate dateCreation, Banque banque) {
    super();
    this.id = id;
    this.proprietaire = proprietaire;
    this.typeCompte = typeCompte;
    this.solde = solde;
    this.dateCreation = dateCreation;
    this.banque = banque;
  }

  public Compte(String proprietaire, String typeCompte, double solde,
      LocalDate dateCreation, Banque banque) {
    super();
    this.proprietaire = proprietaire;
    this.typeCompte = typeCompte;
    this.solde = solde;
    this.dateCreation = dateCreation;
    this.banque = banque;
  }

  public Compte() {
    super();
  }

}

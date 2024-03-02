package com.gk.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Banque {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String nom;
  private String adresse;
  private double capital;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "banque")
  private List<Compte> comptes;

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

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public double getCapital() {
    return capital;
  }

  public void setCapital(double capital) {
    this.capital = capital;
  }

  public List<Compte> getComptes() {
    return comptes;
  }

  public void setComptes(List<Compte> comptes) {
    this.comptes = comptes;
  }

  @Override
  public String toString() {
    return "Banque [id=" + id + ", nom=" + nom + ", adresse=" + adresse
        + ", capital=" + capital + ", comptes=" + comptes + "]";
  }

  public Banque(long id, String nom, String adresse, double capital,
      List<Compte> comptes) {
    super();
    this.id = id;
    this.nom = nom;
    this.adresse = adresse;
    this.capital = capital;
    this.comptes = comptes;
  }

  public Banque(String nom, String adresse, double capital,
      List<Compte> comptes) {
    super();
    this.nom = nom;
    this.adresse = adresse;
    this.capital = capital;
    this.comptes = comptes;
  }

  public Banque() {
    super();
  }

}

package com.gk.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private ERole nom;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public ERole getName() {
    return nom;
  }

  public void setName(ERole nom) {
    this.nom = nom;
  }

  @Override
  public String toString() {
    return "Role [id=" + id + ", nom=" + nom + "]";
  }

  public Role(long id, ERole nom) {
    super();
    this.id = id;
    this.nom = nom;
  }

  public Role(ERole nom) {
    super();
    this.nom = nom;
  }

  public Role() {
    super();
  }

}

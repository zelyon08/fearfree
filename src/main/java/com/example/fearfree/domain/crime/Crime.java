package com.example.fearfree.domain.crime;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "crimes")
public class Crime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    private String nom;

    public Crime(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Crime() {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Crime)) return false;
        Crime crime = (Crime) o;
        return getId() == crime.getId() && Objects.equals(getNom(), crime.getNom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNom());
    }

    @Override
    public String toString() {
        return "Crime{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}

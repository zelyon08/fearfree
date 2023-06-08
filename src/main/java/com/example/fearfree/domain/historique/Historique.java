package com.example.fearfree.domain.historique;

import com.example.fearfree.domain.user.User;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Historique")
public class Historique {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    private String nomcrime;

    private String statut;

    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;

    public Historique(){
    };

    public Historique(int id, String nomcrime, String statut, Timestamp date, User user) {
        this.id = id;
        this.nomcrime = nomcrime;
        this.statut = statut;
        this.date = date;
        this.user = user;
    }

    public String getNomcrime() {
        return nomcrime;
    }

    public void setNomcrime(String nomcrime) {
        this.nomcrime = nomcrime;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Historique{" +
                "id=" + id +
                ", nomcrime='" + nomcrime + '\'' +
                ", statut='" + statut + '\'' +
                ", date=" + date +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Historique)) return false;
        Historique that = (Historique) o;
        return getId() == that.getId() && Objects.equals(getNomcrime(), that.getNomcrime()) && Objects.equals(getStatut(), that.getStatut()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getUser(), that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNomcrime(), getStatut(), getDate(), getUser());
    }
}

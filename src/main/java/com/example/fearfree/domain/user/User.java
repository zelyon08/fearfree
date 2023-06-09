package com.example.fearfree.domain.user;

import com.example.fearfree.domain.historique.Historique;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    private String nom;

    private String prenom;

    private String email;

    private String username;

    private String password;

    private Timestamp datenaissance;

    private  boolean actif;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    /*
    @OneToMany
    @JoinTable(
            name = "Historique",
            joinColumns = @JoinColumn(name = "idUser")
    )
    private List<Historique> historiques = new ArrayList<>();


     */

    public User(int id, String nom, String prenom, String email, String username, String password, Timestamp date, boolean actif) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.username = username;
        this.password = password;
        this.datenaissance = date;
        this.actif = actif;
    }

    public User() {

    }

    public Timestamp getDatenaissance() {
        return datenaissance;
    }
/*
    public List<Historique> getHistoriques() {
        return historiques;
    }

    public void setHistoriques(List<Historique> historiques) {
        this.historiques = historiques;
    }

 */

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Timestamp getDate() {
        return datenaissance;
    }

    public boolean isActif() {
        return actif;
    }

    public Set<Role> getRoles() {
        return roles;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDatenaissance(Timestamp datenaissance) {
        this.datenaissance = datenaissance;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() && isActif() == user.isActif() && getNom().equals(user.getNom()) && getPrenom().equals(user.getPrenom()) && getEmail().equals(user.getEmail()) && getUsername().equals(user.getUsername()) && getPassword().equals(user.getPassword()) && getDate().equals(user.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNom(), getPrenom(), getEmail(), getUsername(), getPassword(), getDate(), isActif());
    }
}

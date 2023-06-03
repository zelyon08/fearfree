package com.example.fearfree.domain.incident;

import com.example.fearfree.domain.crime.Crime;
import com.example.fearfree.domain.risque.Risque;
import com.example.fearfree.domain.user.User;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "incident")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idcrime")
    private Crime crime;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idrisque")
    private Risque risque;

    private Timestamp dateincident;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Risque getRisque() {
        return risque;
    }

    public void setRisque(Risque risque) {
        this.risque = risque;
    }

    public Crime getCrime() {
        return crime;
    }

    public void setCrime(Crime crime) {
        this.crime = crime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

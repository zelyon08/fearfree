package com.example.fearfree.domain.risque;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class Risque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "long", nullable = false)
    private double longitude;

    @Column(name = "lat", nullable = false)
    private  double latitude;

    private  int radus;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getRadus() {
        return radus;
    }

    public void setRadus(int radus) {
        this.radus = radus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Risque)) return false;
        Risque risque = (Risque) o;
        return getId() == risque.getId() && Double.compare(risque.getLongitude(), getLongitude()) == 0 && Double.compare(risque.getLatitude(), getLatitude()) == 0 && getRadus() == risque.getRadus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLongitude(), getLatitude(), getRadus());
    }

    @Override
    public String toString() {
        return "Risque{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", radus=" + radus +
                '}';
    }
}

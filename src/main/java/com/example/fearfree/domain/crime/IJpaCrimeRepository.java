package com.example.fearfree.domain.crime;

import com.example.fearfree.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IJpaCrimeRepository extends JpaRepository<Crime, Integer>, JpaSpecificationExecutor<Crime> {

    @Query("SELECT c FROM Crime c WHERE c.nom = :nom")
    public Optional<User> getCrimeByName(@Param("nom") String nom);
}

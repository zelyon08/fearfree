package com.example.fearfree.domain.historique;

import com.example.fearfree.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IJpaHistoriqueRepository extends JpaRepository<Historique, Integer>, JpaSpecificationExecutor<Historique> {

    @Query("SELECT h FROM Historique h WHERE h.user = :user")
    public List<Historique> getHistoriquesByUser(@Param("user") User user);

}

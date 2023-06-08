package com.example.fearfree.infrastructure.Historique;

import com.example.fearfree.domain.historique.Historique;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueDao extends CrudRepository<Historique, Integer> {
}

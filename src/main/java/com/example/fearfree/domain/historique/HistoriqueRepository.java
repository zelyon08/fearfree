package com.example.fearfree.domain.historique;

import java.util.Optional;

public interface HistoriqueRepository {

    Optional<Historique> findHistoriqueById(int id);

    Historique addHistorique(Historique historique);

    void deleteHistorique(int id);
}

package com.example.fearfree.infrastructure.Historique;

import com.example.fearfree.domain.historique.Historique;
import com.example.fearfree.domain.historique.HistoriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaHistoriqueRepository implements HistoriqueRepository {

    @Autowired
    private  HistoriqueDao historiqueDao;

    public JpaHistoriqueRepository(HistoriqueDao historiqueDao) {
        this.historiqueDao = historiqueDao;
    }

    @Override
    public Optional<Historique> findHistoriqueById(int id) {
        return historiqueDao.findById(id);
    }

    @Override
    public Historique addHistorique(Historique historique) {
        return historiqueDao.save(historique);
    }

    @Override
    public void deleteHistorique(int id) {
        historiqueDao.deleteById(id);
    }
}

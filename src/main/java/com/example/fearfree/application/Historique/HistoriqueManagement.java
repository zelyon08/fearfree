package com.example.fearfree.application.Historique;

import com.example.fearfree.domain.historique.Historique;
import com.example.fearfree.domain.historique.HistoriqueRepository;
import com.example.fearfree.domain.historique.IJpaHistoriqueRepository;
import com.example.fearfree.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriqueManagement {

    @Autowired
    private HistoriqueRepository historiqueRepository;

    @Autowired
    private IJpaHistoriqueRepository iJpaHistoriqueRepository;

    public HistoriqueManagement(HistoriqueRepository historiqueRepository, IJpaHistoriqueRepository iJpaHistoriqueRepository) {
        this.historiqueRepository = historiqueRepository;
        this.iJpaHistoriqueRepository = iJpaHistoriqueRepository;
    }

    public  List<Historique> getHistoriquesByUser(User user){
        return  iJpaHistoriqueRepository.getHistoriquesByUser(user);
    };

    Optional<Historique> findHistoriqueById(int id){
        return historiqueRepository.findHistoriqueById(id);
    }

    Historique addHihstorique(Historique historique){
        return historiqueRepository.addHistorique(historique);
    }

    void deleteHistorique(int id){
        historiqueRepository.deleteHistorique(id);
    }

}

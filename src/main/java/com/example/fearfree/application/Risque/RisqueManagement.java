package com.example.fearfree.application.Risque;

import com.example.fearfree.domain.risque.IJpaRisqueRepository;
import com.example.fearfree.domain.risque.Risque;
import com.example.fearfree.domain.risque.RisqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RisqueManagement {

    @Autowired
    private RisqueRepository risqueRepository;

    @Autowired
    private IJpaRisqueRepository iJpaRisqueRepository;

    public RisqueManagement(RisqueRepository risqueRepository, IJpaRisqueRepository iJpaRisqueRepository) {
        this.risqueRepository = risqueRepository;
        this.iJpaRisqueRepository = iJpaRisqueRepository;
    }

    public List<Risque> getRisque(){return iJpaRisqueRepository.findAll();}

    public Optional<Risque> findRisqueById(int id){return risqueRepository.findRisqueById(id);}

    public void deleteRisque(int id){risqueRepository.deleteRisque(id);}

    public Risque addRisque(Risque risque){return risqueRepository.addRisque(risque);}

    public Risque updateRisque(Risque risque){
        Optional<Risque> risque1 = risqueRepository.findRisqueById(risque.getId());
        if(risque1.isPresent()){
            return risqueRepository.updateRisque(risque);
        }
        return null;
    }

}

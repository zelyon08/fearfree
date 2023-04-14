package com.example.fearfree.infrastructure.Risque;

import com.example.fearfree.domain.risque.Risque;
import com.example.fearfree.domain.risque.RisqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaRisqueRepository implements RisqueRepository {

    @Autowired
    private  RisqueDao risqueDao;

    public JpaRisqueRepository(RisqueDao risqueDao) {
        this.risqueDao = risqueDao;
    }


    @Override
    public Optional<Risque> findRisqueById(int id) {
        return risqueDao.findById(id);
    }

    @Override
    public Risque addRisque(Risque risque) {
        return risqueDao.save(risque);
    }

    @Override
    public Risque updateRisque(Risque risque) {
        return risqueDao.save(risque);
    }

    @Override
    public void deleteRisque(int id) {
        risqueDao.deleteById(id);
    }
}

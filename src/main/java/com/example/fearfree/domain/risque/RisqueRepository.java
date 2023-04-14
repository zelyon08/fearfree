package com.example.fearfree.domain.risque;

import java.util.Optional;

public interface RisqueRepository {

    Optional<Risque> findRisqueById(int id);

    Risque addRisque(Risque risque);

    Risque updateRisque(Risque risque);

    void deleteRisque(int id);

}

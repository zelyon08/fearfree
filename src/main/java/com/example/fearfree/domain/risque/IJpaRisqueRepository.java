package com.example.fearfree.domain.risque;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IJpaRisqueRepository extends JpaRepository<Risque, Integer>, JpaSpecificationExecutor<Risque> {
}

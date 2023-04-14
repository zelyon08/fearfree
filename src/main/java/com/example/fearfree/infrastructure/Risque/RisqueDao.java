package com.example.fearfree.infrastructure.Risque;

import com.example.fearfree.domain.risque.Risque;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RisqueDao extends CrudRepository<Risque, Integer> {
}

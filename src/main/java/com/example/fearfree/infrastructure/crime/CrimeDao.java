package com.example.fearfree.infrastructure.crime;

import com.example.fearfree.domain.crime.Crime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrimeDao extends CrudRepository<Crime, Integer> {
}

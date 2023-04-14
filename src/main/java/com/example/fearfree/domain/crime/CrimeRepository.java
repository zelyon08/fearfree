package com.example.fearfree.domain.crime;

import java.util.Optional;

public interface CrimeRepository {

    Optional<Crime> findCrimeById(int id);

    Crime addCrime(Crime crime);

    Crime updateCrime(Crime crime);

    void deleteCrime(int id);

}

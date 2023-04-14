package com.example.fearfree.infrastructure.crime;

import com.example.fearfree.domain.crime.Crime;
import com.example.fearfree.domain.crime.CrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaCrimeRepository implements CrimeRepository {

    @Autowired
    private  CrimeDao crimeDao;

    public JpaCrimeRepository(CrimeDao crimeDao) {
        this.crimeDao = crimeDao;
    }

    @Override
    public Optional<Crime> findCrimeById(int id) {
        return crimeDao.findById(id);
    }

    @Override
    public Crime addCrime(Crime crime) {
        return crimeDao.save(crime);
    }

    @Override
    public Crime updateCrime(Crime crime) {
        return crimeDao.save(crime);
    }

    @Override
    public void deleteCrime(int id) {
        crimeDao.deleteById(id);
    }
}

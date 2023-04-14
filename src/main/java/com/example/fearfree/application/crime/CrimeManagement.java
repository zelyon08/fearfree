package com.example.fearfree.application.crime;

import com.example.fearfree.domain.crime.Crime;
import com.example.fearfree.domain.crime.CrimeRepository;
import com.example.fearfree.domain.crime.IJpaCrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrimeManagement {

    @Autowired
    private IJpaCrimeRepository iJpaCrimeRepository;

    @Autowired
    private CrimeRepository crimeRepository;

    public CrimeManagement(IJpaCrimeRepository iJpaCrimeRepository, CrimeRepository crimeRepository) {
        this.iJpaCrimeRepository = iJpaCrimeRepository;
        this.crimeRepository = crimeRepository;
    }

    public List<Crime> getAllCrime(){
        return iJpaCrimeRepository.findAll();
    }

    public Optional<Crime> findCrimeById(int id){
        return crimeRepository.findCrimeById(id);
    }

    public Crime addCrime(Crime crime){
        return crimeRepository.addCrime(crime);
    }

    public Crime updateCrime(Crime crime){
        Optional<Crime> crime1 = crimeRepository.findCrimeById(crime.getId());
        if(crime1.isPresent()){
            return crimeRepository.addCrime(crime);
        }
        return  null;
    }

    public void deleteCrime(int id){
        crimeRepository.deleteCrime(id);
    }
}

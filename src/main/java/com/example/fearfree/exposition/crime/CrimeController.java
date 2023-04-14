package com.example.fearfree.exposition.crime;

import com.example.fearfree.application.crime.CrimeManagement;
import com.example.fearfree.domain.crime.Crime;
import com.example.fearfree.domain.risque.Risque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/crime")
@EnableMethodSecurity
public class CrimeController {

    @Autowired
    private CrimeManagement crimeManagement;

    public CrimeController(CrimeManagement crimeManagement) {
        this.crimeManagement = crimeManagement;
    }

    @GetMapping(value = "/CrimesList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllCrimes()
            throws SQLException {

        try {
            List<Crime> crimeList = crimeManagement.getAllCrime();
            Map<String, Object> response = new HashMap<>();
            response.put("CrimeList", crimeList);
            response.put("totalItems", crimeList.size());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/saveCrime", method = RequestMethod.POST)
    public ResponseEntity<Crime> addCrime(@RequestBody Crime crime){
        try{
            Crime crime1 = crimeManagement.addCrime(crime);
            return new ResponseEntity<>(crime1, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

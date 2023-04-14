package com.example.fearfree.exposition.Risque;

import com.example.fearfree.application.Risque.RisqueManagement;
import com.example.fearfree.domain.risque.Risque;
import com.example.fearfree.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Risque")
@EnableMethodSecurity
public class RisqueController {

    @Autowired
    private RisqueManagement risqueManagement;

    @GetMapping(value = "/RisquesList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllRisques()
            throws SQLException {

        try {
            List<Risque> risqueList = risqueManagement.getRisque();
            Map<String, Object> response = new HashMap<>();
            response.put("RisqueList", risqueList);
            response.put("totalItems", risqueList.size());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/saveRisque", method = RequestMethod.POST)
    public ResponseEntity<Risque> addRisque(@RequestBody Risque risque){
        try{
            Risque risque1 = risqueManagement.addRisque(risque);
            return new ResponseEntity<>(risque1, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

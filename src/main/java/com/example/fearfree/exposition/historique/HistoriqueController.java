package com.example.fearfree.exposition.historique;


import com.example.fearfree.application.Historique.HistoriqueManagement;
import com.example.fearfree.application.user.UserManagement;
import com.example.fearfree.domain.historique.Historique;
import com.example.fearfree.domain.risque.Risque;
import com.example.fearfree.domain.user.User;
import com.example.fearfree.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/Historique")
@EnableMethodSecurity
public class HistoriqueController {

    @Autowired
    HistoriqueManagement historiqueManagement;

    @Autowired
    UserManagement userManagement;

    public HistoriqueController(HistoriqueManagement historiqueManagement) {
        this.historiqueManagement = historiqueManagement;
    }

    @GetMapping(value = "/HistoriqueList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getHistoriquesByUser(Authentication auth)
            throws SQLException {

            MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();
            Optional<User> user = userManagement.findUserByEmail(userDetails.getUser().getEmail());
            if(user.isPresent()){
                List<Historique> historiqueList = historiqueManagement.getHistoriquesByUser(user.get());
                Map<String, Object> response = new HashMap<>();
                response.put("historiqueList", historiqueList);
                response.put("totalItems", historiqueList.size());
                return new ResponseEntity<>(response, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

            }


    }
}

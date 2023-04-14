package com.example.fearfree.exposition.user;

import com.example.fearfree.application.user.UserManagement;
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
import java.util.Optional;

@RestController
@RequestMapping("/User")
@EnableMethodSecurity
public class UserController {

    @Autowired
    private UserManagement userManagement;

    @GetMapping(value = "/UsersList", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Map<String, Object>> getAllUsers()
            throws SQLException {

        try {
            List<User> userList = userManagement.getAllUser();
            Map<String, Object> response = new HashMap<>();
            response.put("userList", userList);
            response.put("totalItems", userList.size());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/findUserById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getUser(@RequestParam int id)
            throws SQLException {

        try{
            Optional<User> user = userManagement.findUserById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("user", user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user){
        try{
            User user1 = userManagement.addUser(user);
            return new ResponseEntity<>(user1, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user){

        try {
            return new ResponseEntity<>(userManagement.UpdateUser(user), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<HttpStatus> deleteUser(@RequestParam int id){

        try {
            Optional<User> user = userManagement.findUserById(id);
            if(user.isPresent()){
                userManagement.deleteUser(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}

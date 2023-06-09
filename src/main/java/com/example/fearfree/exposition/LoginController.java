package com.example.fearfree.exposition;

import com.example.fearfree.application.user.UserManagement;
import com.example.fearfree.domain.securite.JwtResponse;
import com.example.fearfree.domain.securite.LoginRequest;
import com.example.fearfree.domain.user.User;
import com.example.fearfree.security.JwtUtil;
import com.example.fearfree.security.MyUserDetails;
import com.example.fearfree.security.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fearfree")
@EnableMethodSecurity
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserManagement userManagement;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Retrieve user details by email
        MyUserDetails userDetails = (MyUserDetails) userDetailsService.loadUserByUsername(loginRequest.getEmail());

        if (userDetails == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Verify the password
        if (!passwordEncoder.matches(loginRequest.getPassword(), userDetails.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        //User user = userDetails.getUser();
        //httpSession.setAttribute("user", user);

        // Returning the access token in the response
        return ResponseEntity.ok("Authentication successful");
    }

        }

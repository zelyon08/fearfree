package com.example.fearfree.exposition;

import com.example.fearfree.application.user.UserManagement;
import com.example.fearfree.domain.user.User;
import com.example.fearfree.security.FearfreeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/oauth")
@EnableMethodSecurity
public class OAuthController {

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    @Autowired
    private UserManagement userManagement;

    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    public String handleCallback(@RequestParam("code") String code, OAuth2AuthenticationToken authentication) {
        System.out.println("J'arrive ic");
        OAuth2AuthorizedClient authorizedClient = authorizedClientService.loadAuthorizedClient(
                "google", authentication.getName());

        if (authorizedClient != null) {
            // Utilise authorizedClient pour accéder au jeton d'accès
            OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
            String tokenValue = accessToken.getTokenValue();
            // Effectue d'autres actions avec le jeton d'accès si nécessaire

            OAuth2User oauth2User = authentication.getPrincipal();

            Optional<User> user = userManagement.findUserByEmail(oauth2User.getAttribute("email"));
            if(user.isPresent()){

                authenticateUser(user.get());

            } else {
               User user1 = new User();
               user1.setNom(oauth2User.getAttribute("fullName"));
                user1.setPrenom(oauth2User.getAttribute("firstName"));
                user1.setUsername(oauth2User.getAttribute("userName"));
                user1.setEmail(oauth2User.getAttribute("email"));
                user1.setPassword(generateRandomPassword());
                user1.setActif(true);
                System.out.println(user1.toString());
                userManagement.addUser(user1);

                authenticateUser(user1);
            }


            return "redirect:/User/UsersList";
        } else {
            // Gère les cas où le jeton d'accès n'est pas disponible
            return "redirect:/login";
        }


    }

    private void authenticateUser(User user) {
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public static String generateRandomPassword() {
        // Génère une chaîne aléatoire pour le mot de passe
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        int length = 10;
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }

}

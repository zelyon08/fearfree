package com.example.fearfree.application.user;

import com.example.fearfree.domain.user.IJpaUserRepository;
import com.example.fearfree.domain.user.User;
import com.example.fearfree.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManagement {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IJpaUserRepository iJpaUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserManagement(UserRepository userRepository, IJpaUserRepository iJpaUserRepository) {
        this.userRepository = userRepository;
        this.iJpaUserRepository = iJpaUserRepository;
    }

    public List<User> getAllUser(){
        return  iJpaUserRepository.findAll();
    }

    public Optional<User> findUserById(int id){
        return userRepository.findUserById(id);
    }

    public Optional<User> findUserByEmail(String email){
        return iJpaUserRepository.getUserByUseremail(email);
    }

    public Optional<User> findUserByUsername(String username){
        return iJpaUserRepository.getUserByUsername(username);
    }


    public User UpdateUser(User user){
        Optional<User> user1 = userRepository.findUserById(user.getId());
        if(user1.isPresent()){
            return userRepository.updateUser(user);
        }

        return null;
    }

    public User addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.addUser(user);
    }

    public User authenticateUser(String username, String password) {
        // Recherche de l'utilisateur dans la base de données en fonction du nom d'utilisateur
        Optional<User> user = iJpaUserRepository.getUserByUseremail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Vérification du mot de passe
        if (!passwordEncoder.matches(password, user.get().getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        // Authentification réussie
        return user.get();
    }

    public void  deleteUser(int id){
        userRepository.deleteUser(id);
    }
}

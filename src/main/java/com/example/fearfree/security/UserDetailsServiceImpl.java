package com.example.fearfree.security;

import com.example.fearfree.domain.user.User;
import com.example.fearfree.domain.user.IJpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IJpaUserRepository userRepository;

    @Override
    public MyUserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Optional<User> user = userRepository.getUserByUsername(username);

        return user.map(MyUserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("User not find "+username));

    }

}


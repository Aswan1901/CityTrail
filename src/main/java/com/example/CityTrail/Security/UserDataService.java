package com.example.CityTrail.Security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDataService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return User.builder()
                .username("user")
                .password("$2a$12$4leyAR.ClA1VZo.k7800NObq8ZRd5L13/5CeotFoHCZ1UH1BqClsa")
                .build();
    }
}
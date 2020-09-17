package com.project.giftoo.config;

import com.project.giftoo.entities.User;
import com.project.giftoo.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImplimentation implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImplimentation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = this.userRepository.findByUsername(username);
        if ( !user.isPresent() )
            throw new UsernameNotFoundException("username "+username+" not found");
        return user.get();
    }
}

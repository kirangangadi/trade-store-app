package com.db.tradestore.service;

import com.db.tradestore.model.Users;
import com.db.tradestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<Users> user = userRepository.findById(userName);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(userName);
        }
        return User.withUsername(user.get().getUsername())
                .password(user.get().getPassword())
                .roles(user.get().getRoles().toArray(new String[user.get().getRoles().size()]))
                .build();
    }
}

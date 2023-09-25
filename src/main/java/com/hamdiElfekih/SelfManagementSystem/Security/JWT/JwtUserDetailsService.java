package com.hamdiElfekih.SelfManagementSystem.Security.JWT;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hamdiElfekih.SelfManagementSystem.Entity.User;
import com.hamdiElfekih.SelfManagementSystem.Model.DTO.UserDTO;
import com.hamdiElfekih.SelfManagementSystem.Repository.SelfManagementSystemRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private SelfManagementSystemRepository selfManagementSystemRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        List<User> users = selfManagementSystemRepository.findByEmail(email);

        User user = users.get(0);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                new ArrayList<>());
    }

    public User save(UserDTO user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return selfManagementSystemRepository.save(newUser);
    }
}

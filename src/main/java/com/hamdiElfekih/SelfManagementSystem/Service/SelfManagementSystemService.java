package com.hamdiElfekih.SelfManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hamdiElfekih.SelfManagementSystem.Entity.User;
import com.hamdiElfekih.SelfManagementSystem.Repository.SelfManagementSystemRepository;

@Service
public class SelfManagementSystemService {

    @Autowired
    SelfManagementSystemRepository selfManagementSystemRepository;

    public List<User> getAllUsers() {
        return selfManagementSystemRepository.findAll();
    }

    public void setUser(User user) {
        selfManagementSystemRepository.save(user);
    }

    public void deleteUserById(Long id) {
        selfManagementSystemRepository.deleteById(id);
    }

    public ResponseEntity<User> updateUserById(Long id, User user) {

        Optional<User> userData = selfManagementSystemRepository.findById(id);
        if (userData.isPresent()) {

            User user_ = userData.get();
            user_.setFirstName(user.getFirstName());
            user_.setLastName(user.getLastName());
            user_.setEmail(user.getEmail());
            user_.setPassword(user.getPassword());
            user_.setJobTitle(user.getJobTitle());
            return new ResponseEntity<>(selfManagementSystemRepository.save(user_), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteAllUsers() {
        selfManagementSystemRepository.deleteAll();
    }

    public User getUserById(Long id) {
        return selfManagementSystemRepository.findById(id).get();
    }
}

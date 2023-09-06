package com.hamdiElfekih.SelfManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}

package com.hamdiElfekih.SelfManagementSystem.Controller;

import com.hamdiElfekih.SelfManagementSystem.Entity.User;
import com.hamdiElfekih.SelfManagementSystem.Service.SelfManagementSystemService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SelfManagementSystemController {

    @Autowired
    SelfManagementSystemService selfManagementSystemService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get-users")
    public List<User> getAllUsers() {
        return selfManagementSystemService.getAllUsers();
    }

    @PostMapping("/add-user")
    public void setUser(@RequestBody User user) {
        selfManagementSystemService.setUser(user);
    }

    @DeleteMapping("/delete-user/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        selfManagementSystemService.deleteUserById(id);
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
        return selfManagementSystemService.updateUserById(id, user);
    }
}

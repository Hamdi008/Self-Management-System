package com.hamdiElfekih.SelfManagementSystem.Controller;

import com.hamdiElfekih.SelfManagementSystem.Entity.User;
import com.hamdiElfekih.SelfManagementSystem.Service.SelfManagementSystemService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SelfManagementSystemController {

    @Autowired
    SelfManagementSystemService selfManagementSystemService;

    @GetMapping("/get-users")
    public List<User> getAllUsers() {
        return selfManagementSystemService.getAllUsers();
    }

    @PostMapping("/add-user")
    public void setUser(@RequestBody User user) {
        selfManagementSystemService.setUser(user);
    }

}

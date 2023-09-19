package com.hamdiElfekih.SelfManagementSystem.Controller;

import com.hamdiElfekih.SelfManagementSystem.Model.DTO.UserDTO;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class SelfManagementSystemController {

    @Autowired
    SelfManagementSystemService selfManagementSystemService;

    @PostMapping("/add-user")
    public void setUser(@RequestBody UserDTO userDTO) {
        selfManagementSystemService.setUser(userDTO);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody UserDTO user) {
        return selfManagementSystemService.signUp(user);
    }

    @GetMapping("/get-users")
    public List<UserDTO> getAllUsers() {
        return selfManagementSystemService.getAllUsers();
    }

    @GetMapping("/get-user/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id) {
        return selfManagementSystemService.getUserById(id);
    }

    @GetMapping("/get-users-by-firstName")
    public List<UserDTO> getUsersByFirstName(@RequestParam String firstName) {
        return selfManagementSystemService.getUsersByFirstName(firstName);
    }

    @GetMapping("/get-users-by-lastName")
    public List<UserDTO> getUsersByLastName(@RequestParam String lastName) {
        return selfManagementSystemService.getUsersByLastName(lastName);
    }

    @GetMapping("/get-users-by-jobTitle")
    public List<UserDTO> getUsersByJobTitle(@RequestParam String jobTitle) {
        return selfManagementSystemService.getUsersByJobTitle(jobTitle);
    }

    @GetMapping("/get-users-by-email")
    public List<UserDTO> getUsersByEmail(@RequestParam String email) {
        return selfManagementSystemService.getUsersByEmail(email);
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable("id") Long id, @RequestBody UserDTO user) {
        return selfManagementSystemService.updateUserById(id, user);
    }

    @DeleteMapping("/delete-user/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        selfManagementSystemService.deleteUserById(id);
    }

    @DeleteMapping("/delete-all-users")
    public void deleteAllUsers() {
        selfManagementSystemService.deleteAllUsers();
    }

}

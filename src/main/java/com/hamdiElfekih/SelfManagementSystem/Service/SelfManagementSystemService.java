package com.hamdiElfekih.SelfManagementSystem.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hamdiElfekih.SelfManagementSystem.Entity.User;
import com.hamdiElfekih.SelfManagementSystem.Model.DTO.UserDTO;
import com.hamdiElfekih.SelfManagementSystem.Repository.SelfManagementSystemRepository;

@Service
public class SelfManagementSystemService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    SelfManagementSystemRepository selfManagementSystemRepository;

    public List<UserDTO> getAllUsers() {
        List<User> users = selfManagementSystemRepository.findAll();

        List<UserDTO> result = new ArrayList<UserDTO>();
        for (User it : users) {
            result.add(UserDTO.convertUserToDTO(it));
        }
        return result;
    }

    public UserDTO getUserById(Long id) {
        return UserDTO.convertUserToDTO(selfManagementSystemRepository.findById(id).get());
    }

    public List<UserDTO> getUsersByFirstName(String firstName) {
        List<User> users = selfManagementSystemRepository.findByFirstName(firstName);

        List<UserDTO> result = new ArrayList<UserDTO>();
        for (User it : users) {
            result.add(UserDTO.convertUserToDTO(it));
        }
        return result;
    }

    public List<UserDTO> getUsersByLastName(String lastName) {
        List<User> users = selfManagementSystemRepository.findByLastName(lastName);

        List<UserDTO> result = new ArrayList<UserDTO>();
        for (User it : users) {
            result.add(UserDTO.convertUserToDTO(it));
        }
        return result;
    }

    public List<UserDTO> getUsersByJobTitle(String jobTitle) {
        List<User> users = selfManagementSystemRepository.findByJobTitle(jobTitle);

        List<UserDTO> result = new ArrayList<UserDTO>();
        for (User it : users) {
            result.add(UserDTO.convertUserToDTO(it));
        }
        return result;
    }

    public List<UserDTO> getUsersByEmail(String email) {
        List<User> users = selfManagementSystemRepository.findByEmail(email);

        List<UserDTO> result = new ArrayList<UserDTO>();
        for (User it : users) {
            result.add(UserDTO.convertUserToDTO(it));
        }
        return result;
    }

    public void setUser(UserDTO userDTO) {
        User user = UserDTO.convertDTOToUser(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        selfManagementSystemRepository.save(user);
    }

    public void deleteUserById(Long id) {
        selfManagementSystemRepository.deleteById(id);
    }

    public ResponseEntity<UserDTO> updateUserById(Long id, UserDTO user) {

        Optional<User> userData = selfManagementSystemRepository.findById(id);
        if (userData.isPresent()) {

            UserDTO user_ = UserDTO.convertUserToDTO(userData.get());
            user_.setFirstName(user.getFirstName());
            user_.setLastName(user.getLastName());
            user_.setEmail(user.getEmail());
            user_.setPassword(user.getPassword());
            user_.setJobTitle(user.getJobTitle());
            return new ResponseEntity<>(
                    UserDTO.convertUserToDTO(selfManagementSystemRepository.save(UserDTO.convertDTOToUser(user_))),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteAllUsers() {
        selfManagementSystemRepository.deleteAll();
    }

    public ResponseEntity<UserDTO> signUp(UserDTO user) {

        User userData = UserDTO.convertDTOToUser(user);
        if (!selfManagementSystemRepository.findByEmail(userData.getEmail()).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.FOUND);
        } else {
            userData.setPassword(passwordEncoder.encode(userData.getPassword()));
            return new ResponseEntity<>(UserDTO.convertUserToDTO(selfManagementSystemRepository.save(userData)),
                    HttpStatus.OK);
        }
    }

    public ResponseEntity<UserDTO> signIn(UserDTO user) {

        if (!selfManagementSystemRepository.findByEmail(user.getEmail()).isEmpty() &&
                !selfManagementSystemRepository.findByPassword(user.getPassword()).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

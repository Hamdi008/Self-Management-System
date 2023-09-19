package com.hamdiElfekih.SelfManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hamdiElfekih.SelfManagementSystem.Entity.User;

public interface SelfManagementSystemRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.firstName = :firstName")
    List<User> findByFirstName(String firstName);

    @Query("SELECT u FROM User u WHERE u.lastName = :lastName")
    List<User> findByLastName(String lastName);

    @Query("SELECT u FROM User u WHERE u.jobTitle = :jobTitle")
    List<User> findByJobTitle(String jobTitle);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    List<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.password = :password")
    List<User> findByPassword(String password);
}

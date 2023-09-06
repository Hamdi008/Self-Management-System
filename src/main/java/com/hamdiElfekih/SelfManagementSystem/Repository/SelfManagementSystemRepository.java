package com.hamdiElfekih.SelfManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hamdiElfekih.SelfManagementSystem.Entity.User;

public interface SelfManagementSystemRepository extends JpaRepository<User, Long> {

}

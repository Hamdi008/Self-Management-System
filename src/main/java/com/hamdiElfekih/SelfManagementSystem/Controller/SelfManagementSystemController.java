package com.hamdiElfekih.SelfManagementSystem.Controller;

import com.hamdiElfekih.SelfManagementSystem.Service.SelfManagementSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SelfManagementSystemController {

    @Autowired
    SelfManagementSystemService selfManagementSystemService;

    @GetMapping("/name")
    public String getName(){
        return selfManagementSystemService.getName();
    }
}

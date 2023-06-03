package com.msvc.hotel.controllers;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    @GetMapping
    public ResponseEntity<List<String>> listarStaff(){
        List<String> staff = Arrays.asList("David","Alberto","Liz","Emilie","Henry");
        return ResponseEntity.ok(staff);
    }

}

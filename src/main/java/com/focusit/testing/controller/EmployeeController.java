package com.focusit.testing.controller;

import com.focusit.testing.entity.Employee;
import com.focusit.testing.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public ResponseEntity<?> getAllEmployees(){
        return ResponseEntity.ok(employeeRepository.findAll());
    }
}

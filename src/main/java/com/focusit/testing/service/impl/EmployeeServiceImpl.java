package com.focusit.testing.service.impl;

import com.focusit.testing.entity.Employee;
import com.focusit.testing.respository.EmployeeRepository;
import com.focusit.testing.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}

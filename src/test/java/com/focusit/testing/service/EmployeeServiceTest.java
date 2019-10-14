package com.focusit.testing.service;

import com.focusit.testing.entity.Employee;
import com.focusit.testing.respository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    public void checkGetEmployeesTest(){
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("user1", "password1"));
        employees.add(new Employee("user2", "password2"));

        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> userList = employeeService.getEmployees();

        assertEquals(2, userList.size());

        verify(employeeRepository, times(1)).findAll();
    }
}

package com.focusit.testing.test.controller;

import com.focusit.testing.entity.Employee;
import com.focusit.testing.respository.EmployeeRepository;
import com.focusit.testing.service.EmployeeService;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    public void checkGetEmployeesTest() throws Exception{
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("user1", "password1"));
        employees.add(new Employee("user2", "password2"));

        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> userList = employeeService.getEmployees();

        this.mockMvc.perform(get("/employee/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].name", CoreMatchers.is(employees.get(0).getName())));
    }
}

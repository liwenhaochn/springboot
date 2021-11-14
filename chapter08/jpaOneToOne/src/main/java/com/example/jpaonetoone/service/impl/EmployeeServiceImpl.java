package com.example.jpaonetoone.service.impl;

import com.example.jpaonetoone.entity.Employee;
import com.example.jpaonetoone.repository.EmployeeRepo;
import com.example.jpaonetoone.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getEmployeeList() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findEmployeeById(long id) {
        return employeeRepo.findById(id);
    }
}

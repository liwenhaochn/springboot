package com.example.jpaonetoone.service;


import com.example.jpaonetoone.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getEmployeeList();

    public Employee findEmployeeById(long id);
}

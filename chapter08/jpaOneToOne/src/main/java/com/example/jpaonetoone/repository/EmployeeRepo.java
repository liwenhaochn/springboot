package com.example.jpaonetoone.repository;

import com.example.jpaonetoone.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

//    Employee findById(long id);

    Employee deleteById(long id);
}

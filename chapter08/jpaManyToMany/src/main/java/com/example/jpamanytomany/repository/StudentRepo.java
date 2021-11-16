package com.example.jpamanytomany.repository;

import com.example.jpamanytomany.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {

}

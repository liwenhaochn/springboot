package com.example.jpamanytomany.repository;

import com.example.jpamanytomany.entity.Student;
import com.example.jpamanytomany.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    
}

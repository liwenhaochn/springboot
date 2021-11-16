package com.example.jpamanytomany;

import com.example.jpamanytomany.entity.Student;
import com.example.jpamanytomany.entity.Teacher;
import com.example.jpamanytomany.repository.StudentRepo;
import com.example.jpamanytomany.repository.TeacherRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class JpaManyToManyApplicationTests {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private TeacherRepo teacherRepo;

    @Test
    void contextLoads() {
        Set<Teacher> teacherSet = new HashSet<>();
        Set<Student> studentSet = new HashSet<>();
        Student student = new Student();
        student.setName("liwenhao");
        studentSet.add(student);
        studentRepo.save(student);

        Student student1 = new Student();
        student1.setName("chenyijun");
        studentSet.add(student1);
        studentRepo.save(student1);

        Teacher teacher = new Teacher();
        teacher.setName("xijinping");
        teacher.setStudentSet(studentSet);
        teacherSet.add(teacher);
        teacherRepo.save(teacher);
    }

}

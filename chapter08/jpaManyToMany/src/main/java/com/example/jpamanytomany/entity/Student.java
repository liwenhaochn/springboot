package com.example.jpamanytomany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(columnDefinition = "enum('male','female')")
    private String sex;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_student", joinColumns = {@JoinColumn(name = "s_id")},inverseJoinColumns =
            {@JoinColumn(name = "t_id")})
    private Set<Teacher> teacherSet;

    public Student(long id, String name, String sex, Set<Teacher> teacherSet) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.teacherSet = teacherSet;
    }

    public Student() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Set<Teacher> getTeacherSet() {
        return teacherSet;
    }

    public void setTeacherSet(Set<Teacher> teacherSet) {
        this.teacherSet = teacherSet;
    }
}

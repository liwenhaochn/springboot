package com.example.jpaonetomany.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    /**
     * 不能用String,否则报错如下
     * Incorrect column specifier for column 'id'
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    /**
     * failed to lazily initialize a collection of role
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    /**
     * 一定要注意，这里的是，一方的表名+主键，而不是多方的！！！
     *
     */
    @JoinColumn(name = "company_id")
    private List<Manager> managerList;


    public Company(long id, String name, List<Manager> managerList) {
        this.id = id;
        this.name = name;
        this.managerList = managerList;
    }

    public Company() {
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

    public List<Manager> getManagerList() {
        return managerList;
    }

    public void setManagerList(List<Manager> managerList) {
        this.managerList = managerList;
    }
}

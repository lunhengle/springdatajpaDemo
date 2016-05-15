package com.lhl.springjpa.bean;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lunhengle on 2015/8/15.
 */
@Entity
public class Depart {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinTable(name = "depart_employee",
            joinColumns = @JoinColumn(name = "depart_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"))
    private List<Employee> employees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

package com.lhl.springjpa.bean;

import javax.persistence.*;

/**
 * Created by lunhengle on 2015/8/15.
 */
@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    // cascade 级联删除 fetch 懒加载 只加载 person  不加载 student
    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY)
    //如果 配置的是 自动更新 则这下边两个字段可以省略
    //address_id 是person 的字段值 id 是 address 中的id
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    //如果有多个字段的话可以嵌套
    //@JoinColumns(value={@JoinColumn(name = "address_id",referencedColumnName = "id"),@JoinColumn(name="address_id",referencedColumnName = "id")})
    private Address address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

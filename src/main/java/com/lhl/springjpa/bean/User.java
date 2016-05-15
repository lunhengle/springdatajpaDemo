package com.lhl.springjpa.bean;

import javax.persistence.*;

/**
 * Created by lunhengle on 2015/8/14.
 */
@Entity
@Table(name = "user")
public class User {
    /**
     * id 生成 策略
     * 默认是 auto
     * GenerationType.AUTO 自动
     * GenerationType.IDENTITY 自动增长 mysql 支持
     * GenerationType.SEQUENCE 采用索引 oracle 支持
     * GenerationType.TABLE
     */
    @Id
    @GeneratedValue
    @Column(name = "id", length = 11, nullable = false)
    private Integer id;
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;*/
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;*/
   /* @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @SequenceGenerator(name = "idGenerator", sequenceName = "userSequence", allocationSize = 1)
    @Column(name = "id")
    private Integer id;*/
   /* @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "userGenerator")
    @TableGenerator(name = "userGenerator", table = "pk_generator", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "user_pk", initialValue = 0, allocationSize = 1)
    @Column(name = "id")
    private Integer id;*/

    @Column(name = "name", length = 255, nullable = true, insertable = true, updatable = true)
    private String name;
    @Column(name = "password", length = 255, nullable = true)
    private String password;
    @Column(name = "phone", length = 255, nullable = true)
    private String phone;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

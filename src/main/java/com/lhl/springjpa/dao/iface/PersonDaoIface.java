package com.lhl.springjpa.dao.iface;

import com.lhl.springjpa.bean.Person;
import com.lhl.springjpa.bean.User;

import java.util.List;

/**
 * Created by lunhengle on 2015/8/16.
 */
public interface PersonDaoIface {
    void add(Person person);
    Person update(Person person);
    void delete(Person person);
    Person findOne(Integer id);
    Person addOrUpdate(Person person);
    List<Person> findAll();
}

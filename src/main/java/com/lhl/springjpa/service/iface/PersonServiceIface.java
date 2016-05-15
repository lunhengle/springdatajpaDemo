package com.lhl.springjpa.service.iface;

import com.lhl.springjpa.bean.Person;

import java.util.List;

/**
 * Created by lunhengle on 2015/8/16.
 */
public interface PersonServiceIface {
    void add(Person person);

    Person update(Person person);

    Person findOne(Integer id);

    void delete(Person person);

    Person addOrUpdate(Person person);
     List<Person> findAll();

    void tranAddOrUpdate(Person person);
}

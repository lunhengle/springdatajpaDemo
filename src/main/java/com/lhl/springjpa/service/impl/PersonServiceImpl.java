package com.lhl.springjpa.service.impl;

import com.lhl.springjpa.bean.Person;
import com.lhl.springjpa.dao.iface.PersonDaoIface;
import com.lhl.springjpa.service.iface.PersonServiceIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by lunhengle on 2015/8/16.
 */
@Service("personServiceIface")
public class PersonServiceImpl implements PersonServiceIface {
    @Autowired
    private PersonDaoIface personDaoIface;


    public void add(Person person) {
        this.getPersonDaoIface().add(person);

    }

    public Person update(Person person) {
        return this.getPersonDaoIface().update(person);
    }

    public Person findOne(Integer id) {
        return this.getPersonDaoIface().findOne(id);
    }

    public void delete(Person person) {
        this.getPersonDaoIface().delete(person);
    }

    public Person addOrUpdate(Person person) {
        return this.getPersonDaoIface().addOrUpdate(person);
    }

    public List<Person> findAll() {
        return this.getPersonDaoIface().findAll();
    }

    @Transactional
    public void tranAddOrUpdate(Person person) {
        this.getPersonDaoIface().add(person);
        //Person p=this.getPersonDaoIface().findOne(100);
        //p.setName("修改后");
        this.getPersonDaoIface().update(person);
    }

    public PersonDaoIface getPersonDaoIface() {
        return personDaoIface;
    }

    public void setPersonDaoIface(PersonDaoIface personDaoIface) {
        this.personDaoIface = personDaoIface;
    }
}

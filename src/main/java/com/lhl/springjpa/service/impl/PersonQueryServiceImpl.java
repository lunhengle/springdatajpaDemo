package com.lhl.springjpa.service.impl;

import com.lhl.springjpa.bean.Person;
import com.lhl.springjpa.dao.iface.PersonQueryDaoIface;
import com.lhl.springjpa.service.iface.PersonQueryServiceIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by lunhengle on 2015/8/26.
 */
@Service("personQueryServiceIface")
public class PersonQueryServiceImpl implements PersonQueryServiceIface {
    @Qualifier("personQueryDaoIface")
    @Autowired
    public PersonQueryDaoIface personQueryDaoIface;
    public List<Person> getPerson() {
        return personQueryDaoIface.getPerson();
    }

    public Person selectSinglePerson(Integer id) {
        return personQueryDaoIface.selectSinglePerson(id);
    }

    public Person selectSinglePerson1(Integer id) {
        return personQueryDaoIface.selectSinglePerson1(id);
    }
    @Transactional
    public void updatePerson(String name, Integer id) {
         personQueryDaoIface.updatePerson(name, id);
    }
    @Transactional
    public void  updatePerson1(String name,Integer id){
        personQueryDaoIface.updatePerson1(name,id);
    }

    @Transactional
    public void insertPerson(String name, Integer age, String address) {
        //personQueryDaoIface.insertPerson(name,age,address);
    }
}

package com.lhl.springjpa.service.iface;

import com.lhl.springjpa.bean.Person;

import java.util.List;

/**
 * Created by lunhengle on 2015/8/26.
 */
public interface PersonQueryServiceIface {
   List<Person> getPerson();
   Person selectSinglePerson(Integer id);
   Person selectSinglePerson1(Integer id);
    void updatePerson(String name,Integer id);
    void updatePerson1(String name,Integer id);
    void insertPerson(String name,Integer age,String address);
}

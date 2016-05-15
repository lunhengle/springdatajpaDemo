package com.lhl.springjpa.dao.impl;


import com.lhl.springjpa.bean.Person;
import com.lhl.springjpa.dao.iface.PersonDaoIface;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by lunhengle on 2015/8/14.
 */
@Repository("personDaoIface")
@Transactional
public class PersonDaoImpl implements PersonDaoIface {
    @PersistenceContext
    private EntityManager entityManager;


    public void add(Person person) {
        entityManager.persist(person);
    }

    public Person update(Person person) {
        Person personUpdate = entityManager.find(Person.class, person.getId());
        if (null != personUpdate) {
            if (null != person.getName()) {
                personUpdate.setName(person.getName());
            }
        }
        entityManager.merge(personUpdate);
        return personUpdate;
    }

    public Person findOne(Integer id) {
        return entityManager.find(Person.class, id);
    }

    public void delete(Person person) {
        Person personUpdate = entityManager.find(Person.class, person.getId());
        entityManager.remove(personUpdate);
    }

    public Person addOrUpdate(Person person) {
        return entityManager.merge(person);
    }

    public List<Person> findAll() {
        String sql = "select u from Person u";
        Query query = entityManager.createQuery(sql);
        return query.getResultList();
    }

}

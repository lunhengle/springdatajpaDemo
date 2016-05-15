package com.lhl.springjpa.dao.iface;

import com.lhl.springjpa.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lunhengle on 2015/8/26.
 */
@Repository("personQueryDaoIface")
public interface PersonQueryDaoIface extends JpaRepository<Person, Integer> {
    @Query("select p from Person p ")
    List<Person> getPerson();

    @Query("select p from Person p where p.id=?1")
    Person selectSinglePerson(Integer id);

    @Query("select p from Person p where p.id=:id")
    Person selectSinglePerson1(@Param("id") Integer id);

    @Modifying
    @Query("update Person p set p.name=?1 where p.id=?2")
    void updatePerson(String name, Integer id);

    @Modifying
    @Query("update Person p set p.name=:name where p.id=:id")
    void updatePerson1(@Param("name") String name, @Param("id") Integer id);

    /*@Modifying
    @Query("insert into Person(name,age,address) values (?1,?2,?3)")
    void insertPerson(String name,Integer age,String address);*/

}

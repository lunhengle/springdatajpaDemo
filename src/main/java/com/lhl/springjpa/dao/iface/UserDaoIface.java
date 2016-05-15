package com.lhl.springjpa.dao.iface;

import com.lhl.springjpa.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lunhengle on 2015/8/14.
 */
@Repository("userDaoIface")
public interface UserDaoIface extends JpaRepository<User,Integer> {
    //select * from user where name like '伦%' and phone like '%45%' order by phone desc limit 0,2
    List<User> findTop2ByNameStartingWithAndPhoneContainingOrderByPhoneDesc(String name,String phone);
    //排序方法
    List<User> findByNameStartingWithAndPhoneContaining(String name,String phone,Sort sort);
    //分页
    Page<User> findByNameStartingWithAndPhoneContaining(String name,String phone,Pageable pageable);


}

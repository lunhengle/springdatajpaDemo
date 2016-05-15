package com.lhl.springjpa.service.iface;

import com.lhl.springjpa.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by lunhengle on 2015/8/14.
 */
public interface UserServiceIface {
    /**
     * 添加用户
     */
    void insertUser(User user);

    /**
     * 修改用户
     */
    User updateUser(User user);

    /**
     * 删除用户
     */
    void deleteUser(int id);

/**
 * 得到单个用户
 */
    public User getUser(int id);
    /**
     * 查询所有用户
     *
     * @return list
     */

    List<User> getListUser();

    /**
     * 根据name 和phone 查询user
     * @param name 用户名
     * @param phone 手机号
     * @return  list
     */
    List <User> getListUserByNameAndPhone(String name,String phone);
    /**
     * 根据name 和phone 查询user
     * @param name 用户名
     * @param phone 手机号
     * @return  list
     */
    List <User> getListUserByNameAndPhone(String name,String phone,Sort sort);

    /**
     * 根据name 和phone 查询user
     * @param name 用户名
     * @param phone 手机号
     * @return  list
     */
    Page<User> getListUserByNameAndPhone(String name,String phone,Pageable pageable);
}

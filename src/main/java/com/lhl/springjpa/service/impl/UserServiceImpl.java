package com.lhl.springjpa.service.impl;

import com.lhl.springjpa.bean.User;
import com.lhl.springjpa.dao.iface.UserDaoIface;
import com.lhl.springjpa.service.iface.UserServiceIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lunhengle on 2015/8/14.
 */
@Service("userServiceIface")
public class UserServiceImpl implements UserServiceIface {
    @Autowired
    private UserDaoIface userDaoIface;


    public UserDaoIface getUserDaoIface() {
        return userDaoIface;
    }

    public void setUserDaoIface(UserDaoIface userDaoIface) {
        this.userDaoIface = userDaoIface;
    }

    /**
     * 添加用户
     *
     * @param user
     */
    public void insertUser(User user) {
        this.getUserDaoIface().save(user);
    }

    /**
     * 修改用户
     *
     * @param user
     */
    public User updateUser(User user) {
        User userUpdate = this.getUserDaoIface().findOne(user.getId());
        if (null != userUpdate) {
            if (null != user.getName()) {
                userUpdate.setName(user.getName());
            }
            if (null != user.getPassword()) {
                userUpdate.setPassword(user.getPassword());
            }
            if (null != user.getPhone()) {
                userUpdate.setPhone(user.getPhone());
            }
            this.getUserDaoIface().save(userUpdate);
        }
        return userUpdate;
    }

    /**
     * 删除用户
     *
     * @param id
     */
    public void deleteUser(int id) {
        User user = this.getUserDaoIface().findOne(id);
        if (null != user) {
            this.getUserDaoIface().delete(id);
        }
    }

    /**
     * 得到单个用户
     *
     * @param id
     */
    public User getUser(int id) {
        return this.getUserDaoIface().findOne(id);
    }

    /**
     * 查询所有用户
     *
     * @return list
     */
    public List<User> getListUser() {
        return this.getUserDaoIface().findAll();
    }

    /**
     * 根据name 和phone 查询user
     *
     * @param name  用户名
     * @param phone 手机号
     * @return list
     */
    public List<User> getListUserByNameAndPhone(String name, String phone) {
        return this.getUserDaoIface().findTop2ByNameStartingWithAndPhoneContainingOrderByPhoneDesc(name, phone);
    }

    /**
     * 根据name 和phone 查询user
     *
     * @param name  用户名
     * @param phone 手机号
     * @param sort
     * @return list
     */
    public List<User> getListUserByNameAndPhone(String name, String phone, Sort sort) {
        return this.getUserDaoIface().findByNameStartingWithAndPhoneContaining(name, phone, sort);
    }

    /**
     * 根据name 和phone 查询user
     *
     * @param name     用户名
     * @param phone    手机号
     * @param pageable
     * @return list
     */
    public Page<User> getListUserByNameAndPhone(String name, String phone, Pageable pageable) {
        return this.getUserDaoIface().findByNameStartingWithAndPhoneContaining(name, phone, pageable);
    }
}

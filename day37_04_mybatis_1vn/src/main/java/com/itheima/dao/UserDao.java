package com.itheima.dao;

import com.itheima.pojo.User;

/**
 * 包名:com.itheima.dao
 *
 * @author Leevi
 * 日期2020-12-13  11:03
 */
public interface UserDao {
    /**
     * 根据用户的uid查询用户信息，并且查询出该用户的所有账号信息
     * @param uid
     * @return
     */
    User findByUid(int uid);
}

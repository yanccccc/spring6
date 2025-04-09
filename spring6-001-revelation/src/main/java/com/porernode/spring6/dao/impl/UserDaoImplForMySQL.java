package com.porernode.spring6.dao.impl;

import com.porernode.spring6.dao.UserDao;

public class UserDaoImplForMySQL implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("MySQL数据库正在删除用户信息");
    }
}

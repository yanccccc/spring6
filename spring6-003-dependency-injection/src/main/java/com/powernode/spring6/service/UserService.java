package com.powernode.spring6.service;

import com.powernode.spring6.dao.UserDao;
import com.powernode.spring6.dao.VipDao;

public class UserService {
    private UserDao userDao;
    private VipDao vipDao;

    // ser注入的话，必须提供一个set方法
    // spring容器会调用这个set方法
    // 自己写set方法也可以，但是必须以set开头命名
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setVipDao(VipDao vipDao) {
        this.vipDao = vipDao;
    }

    public void saveUser(){
        userDao.insert();
        vipDao.insert();
    }
}

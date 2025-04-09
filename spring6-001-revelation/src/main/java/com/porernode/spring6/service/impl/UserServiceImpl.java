package com.porernode.spring6.service.impl;

import com.porernode.spring6.dao.UserDao;
import com.porernode.spring6.dao.impl.UserDaoImplForMySQL;
import com.porernode.spring6.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImplForMySQL();

    @Override
    public void deleteById() {
        userDao.deleteById();
    }
}

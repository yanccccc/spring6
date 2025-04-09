package com.porernode.spring6.web;

import com.porernode.spring6.service.UserService;
import com.porernode.spring6.service.impl.UserServiceImpl;

public class UserAction {
    private UserService userService = new UserServiceImpl();

    public void delete() {
        userService.deleteById();
    }
}

package com.powernode.test;

import com.powernode.client.UserService;
import org.junit.Test;
import org.myspringframework.core.ApplicationContext;
import org.myspringframework.core.ClassPathXmlApplicationContext;

public class myspringtest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }
}

package com.powernode.spring6.test;

import com.powernode.spring6.bean.User;
import com.powernode.spring6.beans.MyDataSource;
import com.powernode.spring6.service.CustomerService;
import com.powernode.spring6.service.OrderService;
import com.powernode.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringDITest {
    @Test
    public void testSetDI(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userServiceBean = context.getBean("userServiceBean", UserService.class);
        userServiceBean.saveUser();
    }

    @Test
    public void testConstructorDI(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService customerServiceBean = context.getBean("customerServiceBean", CustomerService.class);
        customerServiceBean.save();

        CustomerService customerServiceBean2 = context.getBean("customerServiceBean2", CustomerService.class);
        customerServiceBean2.save();

        CustomerService customerServiceBean3 = context.getBean("customerServiceBean3", CustomerService.class);
        customerServiceBean3.save();
    }

    @Test
    public void testSetDI2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("set-di.xml");
        OrderService orderService = context.getBean("orderServiceBean", OrderService.class);
        orderService.generate();

        OrderService orderService2 = context.getBean("orderServiceBean2", OrderService.class);
        orderService2.generate();
    }

    @Test
    public void testSimpleTypeSet(){
        ApplicationContext context = new ClassPathXmlApplicationContext("set-di.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void testDataSource(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        MyDataSource dataSource = applicationContext.getBean("dataSource", MyDataSource.class);
        System.out.println(dataSource);
    }
}

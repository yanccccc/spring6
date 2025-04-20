package com.powernode.spring6.test;

import com.powernode.spring6.bean.Dog;
import com.powernode.spring6.bean.People;
import com.powernode.spring6.bean.User;
import com.powernode.spring6.beans.Person;
import com.powernode.spring6.jdbc.MyDataSource;
import com.powernode.spring6.jdbc.MyDataSource1;
import com.powernode.spring6.jdbc.MyDataSource2;
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

    @Test
    public void testArray(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void testP(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        Dog dogBean = applicationContext.getBean("dogBean", Dog.class);
        System.out.println(dogBean);
    }

    @Test
    public void testC(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-c.xml");
        People peopleBean = applicationContext.getBean("peopleBean", People.class);
        System.out.println(peopleBean);
    }

    @Test
    public void testUtil(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-util.xml");
        MyDataSource1 ds1 = applicationContext.getBean("ds1", MyDataSource1.class);
        MyDataSource2 ds2 = applicationContext.getBean("ds2", MyDataSource2.class);
        System.out.println(ds1);
        System.out.println(ds2);
    }

    @Test
    public void testAutowire(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");

//        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
//        orderService.generate();

        CustomerService cs = applicationContext.getBean("cs", CustomerService.class);
        cs.save();
    }

    @Test
    public void testProperties(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-properties.xml");
        MyDataSource ds = applicationContext.getBean("ds", MyDataSource.class);
        System.out.println(ds);
    }
}

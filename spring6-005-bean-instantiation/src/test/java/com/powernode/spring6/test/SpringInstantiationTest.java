package com.powernode.spring6.test;

import com.powernode.spring6.bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInstantiationTest {

    @Test
    public void testConstructor(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void testSimpleFactory(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Vip vip = applicationContext.getBean("vipBean", Vip.class);
        System.out.println(vip);
    }

    @Test
    public void testFactoryMethod(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Order order = applicationContext.getBean("order", Order.class);
        System.out.println(order);
    }

    @Test
    public void testFactoryBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void testDate(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = applicationContext.getBean("studentBean", Student.class);
        System.out.println(student);
    }




}

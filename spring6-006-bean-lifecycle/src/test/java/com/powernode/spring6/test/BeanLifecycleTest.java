package com.powernode.spring6.test;

import com.powernode.spring6.bean.Student;
import com.powernode.spring6.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleTest {
    @Test
    public void testBeanLifecycleFive() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);

        System.out.println("4.调用bean" + user);

        // 只有正常关闭spring容器才会执行销毁方法
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();
    }

    @Test
    public void testRegisterBean(){
        // 自己new的对象
        Student student = new Student();
        System.out.println(student);

        // 将以上自己new的这个对象纳入Spring容器来管理。半路上交给Spring来管理。
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("studentBean", student);

        // 从spring容器中获取
        Object studentBean = factory.getBean("studentBean");
        System.out.println(studentBean);
    }
}

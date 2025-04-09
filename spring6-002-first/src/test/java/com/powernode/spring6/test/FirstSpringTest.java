package com.powernode.spring6.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpringTest {
    @Test
    public void testFirstSpringCode() {
        //获取Spring容器对象
        // ApplicationContext接口下有很多实现类，其中有一个实现类ClassPathXmlApplicationContext
        // ClassPathXmlApplicationContext专门从类路径中加载Spring配置文件中的一个Spring上下文对象
        // 这行代码只要执行，相当于启动了Spring容器，解析spring.xml文件，并且实例化所有bean对象，放到spring容器中
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        //根据bean的id从Spring容器获取这个对象
        Object userDao = applicationContext.getBean("userBean");
        System.out.println(userDao);

        // 如果bean的id不存在，会报错
    }

    @Test
    public void testBeanFactory() {
        // ApplicationContext接口的超级父接口：BeanFactory（Bean工厂，能够生产Bean对象的一个工厂对象）
        // BeanFactory是Ioc容器的顶级接口
        // Spring底层的IoC实现方式 ：XML解析 + 工厂模式 + 反射机制
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Object userDao = applicationContext.getBean("userBean");
        System.out.println(userDao);
    }

    @Test
    public void testBeginInitBean() {
        // 注意：不是在调用getBean方法才创建对象 ，在下面这行代码就已经创建对象了
        new ClassPathXmlApplicationContext("spring.xml");

        // 使用log4j2记录日志信息
        // 第一步 创建日志记录器对象
        // 获取FirstSpringTest类的日志记录器对象，也就是说只要是FirstSpringTest类的代码执行记录日志后，就会输出相关日志信息
        Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);

        // 第二步：记录日志，根据不同级别输出日志
        logger.info("我是一条日志消息");
        logger.debug("我是一条日志消息");
        logger.error("我是一条日志消息");

    }
}

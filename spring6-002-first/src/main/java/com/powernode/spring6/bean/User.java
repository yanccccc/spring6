package com.powernode.spring6.bean;

/**
 * 这是一个Bean，封装用户信息
 */
public class User {
    //Spring怎么实例化对象的
    //通过反射机制拿到全类名实例化对象的
    // Class clazz = Class.forName("com.powernode.spring6.bean.User");
    // Object obj = clazz.newInstance();
    public User() {
        System.out.println("User的无参数构造方法执行");
    }
}

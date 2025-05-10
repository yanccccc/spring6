package com.powernode.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 *
 * Bean的生命周期（5 -> 7 -> 10）：
 * 第一步：实例化Bean（调用无参数构造方法。）
 * 第二步：给Bean属性赋值（调用set方法。）
 * 如果该类实现了Aware相关接口，并调用接口方法
 * Bean初始化前，执行BeanPostProcessor的before方法
 * 是否实现了InitializingBean接口，并调用接口方法
 * 第三步：初始化Bean（会调用Bean的init方法。注意：这个init方法需要自己写，自己配。）
 * Bean初始化后，执行BeanPostProcessor的after方法
 * 第四步：使用Bean
 * 是否实现了DisposableBean接口，并调用接口方法
 * 第五步：销毁Bean（会调用Bean的destroy方法。注意：这个destroy方法需要自己写，自己配。）
 *
 **/
public class User implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean {
    private String name;

    public User() {
        System.out.println("1.实例化Bean");
    }

    public void setName(String name) {
        System.out.println("2.对象属性赋值");
        this.name = name;
    }

    // 这个方法需要自己写，自己配。方法名随意。
    public void initBean(){
        System.out.println("3.初始化bean");
    }

    // 这个方法需要自己写，自己配。方法名随意。
    public void destroyBean(){
        System.out.println("5.销毁bean");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("实现了BeanClassLoaderAware接口" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("实现了BeanFactoryAware接口" + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("实现了BeanNameAware接口" + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("实现了InitializingBean接口");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("实现了DisposableBean接口");
    }
}

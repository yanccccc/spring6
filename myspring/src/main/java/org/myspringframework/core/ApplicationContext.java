package org.myspringframework.core;

public interface ApplicationContext {
    /**
     *
     * @param beanId bean的id标识
     * @return bean对象
     */
    public Object getBean(String beanId);
}

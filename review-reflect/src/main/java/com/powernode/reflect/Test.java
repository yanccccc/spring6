package com.powernode.reflect;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        /*
        需求：
            假设你现在已知以下信息：
                1. 有这样一个类，类名叫做：com.powernode.reflect.User
                2. 这个类符合javabean规范。属性私有化，对外提供公开的setter和getter方法。
                3. 你还知道这个类当中有一个属性，属性的名字叫做 age
                4. 并且你还知道age属性的类型是int类型。
            请使用反射机制调用set方法，给User对象的age属性赋值。
         */
        String className = "com.powernode.reflect.User";
        String propertyName = "age";

        Class clazz = Class.forName(className);
        String methodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);

        //获取属性类型
        Field declaredField = clazz.getDeclaredField(propertyName);
        Method method = clazz.getMethod(methodName, declaredField.getType());


        Object user = clazz.newInstance();

        method.invoke(user,2);
        System.out.println(user);

    }
}

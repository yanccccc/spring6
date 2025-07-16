package org.myspringframework.core;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ClassPathXmlApplicationContext implements ApplicationContext {

    private static final Logger logger = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);

    //一级缓存，key存储的是beanId，value存储的是bean对象
    private Map<String, Object> singleObjects = new HashMap<>();

    /**
     * 解析myspring的配置文件，然后初始化所有的Bean对象。
     *
     * @param configLocation spring配置文件的路径。注意：使用ClassPathXmlApplicationContext，配置文件应当放到类路径下。
     */
    public ClassPathXmlApplicationContext(String configLocation) {
        // 使用Dom4j解析XML文件
        SAXReader saxReader = new SAXReader();

        // 通过全类名创建类对象
        try {
            // 获取类路径下的资源文件(resources)
            InputStream is = getClass().getClassLoader().getResourceAsStream(configLocation);
            // 读取文件
            Document document = saxReader.read(is);
            // 获取所有带<bean>的标签
            List<Node> nodes = document.selectNodes("//bean");
            // 遍历所有bean标签对象
            nodes.forEach(node -> {
                // 强转获取更多方法
                Element element = (Element) node;
                // 获取bean的id
                String beanId = element.attributeValue("id");
                // 获取bean的全类名
                String beanClassName = element.attributeValue("class");
                try {
                    // 使用反射来构造对象
                    Class clazz = Class.forName(beanClassName);
                    // 获取无参数构造方法
                    Constructor constructor = clazz.getConstructor();
                    // 调用无参数构造方法实例化Bean
                    Object obj = constructor.newInstance();
                    // 将构造好的对象放入到一级缓存中
                    singleObjects.put(beanId, obj);
                    logger.info("构造的对象为" + singleObjects);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // 将创建好的对象属性进行赋值
            // 由于要解决循环依赖，所以需要先创建对象在一级缓存中去，然后在进行对象的赋值
            // 使用set方法进行赋值
            nodes.forEach(node -> {
                try {
                    // 强转获取更多方法
                    Element element = (Element) node;
                    // 获取id
                    String beanId = element.attributeValue("id");
                    // 获取bean的全类名
                    String beanClassName = element.attributeValue("class");
                    // 使用反射来构造对象
                    Class clazz = Class.forName(beanClassName);
                    // 获取node下所有的property标签
                    List<Element> properties = element.elements("property");
                    // 遍历property标签下的属性
                    properties.forEach(property -> {
                        // 获取对象name属性
                        String propertyName = property.attributeValue("name");
                        logger.info("属性名：" + propertyName);
                        // 获取set方法名
                        String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                        // 使用反射调用setName方法
                        try {
                            // 获取属性类型
                            Field field = clazz.getDeclaredField(propertyName);
                            // 获取set方法
                            Method method = clazz.getMethod(setMethodName, field.getType());
                            // 给对象属性赋值
                            // 需要知道对象属性是简单类型还是非简单类型
                            String value = property.attributeValue("value");
                            String ref = property.attributeValue("ref");
                            Object actualValue = null;
                            // 如果是简单类型
                            if (value != null) {
                                // 说明这个值是简单类型
                                // 调用set方法(set方法没有返回值)
                                // 我们myspring框架声明一下：我们只支持这些类型为简单类型
                                // byte short int long float double boolean char
                                // Byte Short Integer Long Float Double Boolean Character
                                // String
                                // 获取属性类型名
                                String propertyTypeSimpleName = field.getType().getSimpleName();
                                switch (propertyTypeSimpleName) {
                                    case "byte":
                                    case "Byte":
                                        actualValue = Byte.valueOf(value);
                                        break;
                                    case "short":
                                    case "Short":
                                        actualValue = Short.valueOf(value);
                                        break;
                                    case "int":
                                    case "Integer":
                                        actualValue = Integer.valueOf(value);
                                        break;
                                    case "long":
                                    case "Long":
                                        actualValue = Long.valueOf(value);
                                        break;
                                    case "float":
                                    case "Float":
                                        actualValue = Float.valueOf(value);
                                        break;
                                    case "double":
                                    case "Double":
                                        actualValue = Double.valueOf(value);
                                        break;
                                    case "boolean":
                                    case "Boolean":
                                        actualValue = Boolean.valueOf(value);
                                        break;
                                    case "char":
                                    case "Character":
                                        actualValue = value.charAt(0);
                                        break;
                                    case "String":
                                        actualValue = value;
                                        break;
                                }
                                method.invoke(singleObjects.get(beanId), actualValue);
                            }

                            //如果是非简单类型，直接赋值
                            if (ref != null) {
                                method.invoke(singleObjects.get(beanId), singleObjects.get(ref));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object getBean(String beanId) {
        return singleObjects.get(beanId);
    }
}

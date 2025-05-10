
源码分析：
DefaultSingletonBeanRegistry类中有三个比较重要的缓存：
    private final Map<String, Object> singletonObjects                  一级缓存
    private final Map<String, Object> earlySingletonObjects             二级缓存
    private final Map<String, ObjectFactory<?>> singletonFactories      三级缓存

    这三个缓存都是Map集合。
    Map集合的key存储的都是bean的name（bean id）。

    一级缓存存储的是：单例Bean对象。完整的单例Bean对象，也就是说这个缓存中的Bean对象的属性都已经赋值了。是一个完整的Bean对象。
    二级缓存存储的是：早期的单例Bean对象。这个缓存中的单例Bean对象的属性没有赋值。只是一个早期的实例对象。
    三级缓存存储的是：单例工厂对象。这个里面存储了大量的“工厂对象”，每一个单例Bean对象都会对应一个单例工厂对象。
                    这个集合中存储的是，创建该单例对象时对应的那个单例工厂对象。

    三级缓存解决循环依赖的原理是：首先当实例化A的时候，填充属性的时候需要B的实例化对象，spring就会去实例化B，
    此时A的对象在三级缓存中，当实例化B的时候就会从三级缓存中通过工厂去生成A的对象，生成的A对象放入到二级缓存中，
    并将三级缓存中的A删除，然后将得到的A对象填充给B对象的属性，接着B对象会被放入到一级缓存中并移除三级缓存，此时就可以正常创建A对象

    为什么需要三级缓存？
    主要是为了AOP，如果B对象使用了AOP切面，那么A对象引入的属性B对象就必须是B的代理对象，所以在有循环依赖的情况下需要通过三级缓存来创建代理对象

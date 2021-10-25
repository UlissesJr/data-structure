package top.luobogan.creater.singleton;

/**
 * Created by LuoboGan
 * Date:2021/10/25
 * 饿汉模式，创建的时候进行实例化
 * @author Luobogan
 */
public class PersonHungry {

    private String name;
    private int age;

    private static final PersonHungry instance = new PersonHungry();

    /**
     * 构造器私有，外部不能实例化
     */
    private PersonHungry(){
        System.out.println("构造器被调用了");
    };

    /**
     * 提供给外部的方法
     * @return Person
     */
    public static PersonHungry getInstance(){
        return instance;
    };



}

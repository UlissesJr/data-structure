package top.luobogan.creater.singleton;

/**
 * Created by LuoboGan
 * Date:2021/10/25
 * 懒汉模式，使用的时候再创建
 * @author Luobogan
 */
public class PersonLazy {

    private String name;
    private int age;

    private static PersonLazy instance;

    /**
     * 构造器私有，外部不能实例化
     */
    private PersonLazy(){
        System.out.println("构造器被调用了");
    };

    /**
     * 提供给外部的方法
     * @return Person
     */
    public static synchronized PersonLazy getInstance(){

        if(instance == null){
            instance = new PersonLazy();
        }
        return instance;
    };



}

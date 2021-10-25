package top.luobogan.creater.singleton;

/**
 * Created by LuoboGan
 * Date:2021/10/25
 * 懒汉模式，使用的时候再创建
 * @author Luobogan
 */
public class PersonDoubleCheck {

    private String name;
    private int age;

    private volatile static PersonDoubleCheck instance;

    /**
     * 构造器私有，外部不能实例化
     */
    private PersonDoubleCheck(){
        System.out.println("构造器被调用了");
    };

    /**
     * 提供给外部的方法
     * 双重检查锁 + 内存可见性 volatile
     * @return Person
     */
    public static PersonDoubleCheck getInstance(){

        if(instance == null){
            synchronized (PersonDoubleCheck.class){
                if(instance == null){
                    instance = new PersonDoubleCheck();
                }
            }
        }
        return instance;
    };

}

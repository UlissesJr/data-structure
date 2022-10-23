package top.luobogan.threadCoreKnowledge.singleton;

/**
 * 饿汉式（静态常量）（可用）
 * Created by LuoboGan
 * Date:2022/10/22
 */
public class Singleton1 {

    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

}

package top.luobogan.threadCoreKnowledge.singleton;

/**
 * 描述：     饿汉式（静态代码块）（可用）
 * Created by LuoboGan
 * Date:2022/10/22
 */
public class Singleton2 {

    private final static Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}


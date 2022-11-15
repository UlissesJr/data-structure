package top.luobogan.threadCoreKnowledge.singleton;

/**
 * 描述：     静态内部类方式，可用
 * Created by LuoboGan
 * Date:2022/10/22
 */
public class Singleton7 {

    private Singleton7() {
    }

    private static class SingletonInstance {

        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
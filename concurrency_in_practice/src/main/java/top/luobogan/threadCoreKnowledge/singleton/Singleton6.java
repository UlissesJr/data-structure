package top.luobogan.threadCoreKnowledge.singleton;

/**
 * 描述：     双重检查（推荐面试使用）
 * sync是原子性的和可见性的，对象没有初始完，sychronized里面的就不会释放锁，只是synchronized没有禁止指令重排序
 * 对象还没有初始化，地址已经刷新到主存了，这个问题是在dcl第1步判空准备获取锁的时候发生的，其他线程拿到对象地址，去访问对象变量，结果由于变量还没初始化结束，导致空指针异常
 * Created by LuoboGan
 * Date:2022/10/22
 */
public class Singleton6 {

    private volatile static Singleton6 instance;

    private Singleton6() {

    }

    public static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}

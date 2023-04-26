package top.luobogan.threadCoreKnowledge.startThread;

/**
 * 对比start和run两种启动线程的方式
 * Created by LuoboGan
 * Date:2022-09-17
 */
public class StartAndRunMethod {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };

        new Thread(runnable).run();  // main
        new Thread(runnable).start();  // Thread-1

    }

}

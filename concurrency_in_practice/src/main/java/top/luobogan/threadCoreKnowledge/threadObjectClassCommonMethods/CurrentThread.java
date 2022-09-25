package top.luobogan.threadCoreKnowledge.threadObjectClassCommonMethods;

/**
 * 演示打印main, Thread-0, Thread-1
 * Created by LuoboGan
 * Date:2022-09-25
 */
public class CurrentThread implements Runnable {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        new CurrentThread().run();
        new Thread(new CurrentThread()).start();
        new Thread(new CurrentThread()).start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}


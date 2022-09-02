package top.luobogan.threadCoreKnowledge.createThreads;

/**
 * 采用继承Thread类的方式实现线程
 * Created by LuoboGan
 * Date:2022-08-30
 */
public class ThreadStyle extends Thread{

    public static void main(String[] args) {
        Thread thread = new ThreadStyle();
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("继承Thread类的方式实现线程");
    }
}

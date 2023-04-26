package top.luobogan.threadCoreKnowledge.uncaughtexception;

/**
 * 1. 不加try catch抛出4个异常，都带线程名字
 * 2. 加了try catch,期望捕获到第一个线程的异常，线程234不应该运行，希望看到打印出Caught Exception
 * 3. 执行时发现，根本没有 Caught Exception，线程234依然运行并且抛出异常
 * 说明线程的异常不能用传统方法捕获
 * Created by LuoboGan
 * Date:2022-09-25
 */
public class CantCatchDirectly implements Runnable {

    @SuppressWarnings("all")
    public static void main(String[] args) throws InterruptedException {

        // 这里的try catch 是针对主线程的异常的，是无法捕获到子线程的异常的
        try {
            new Thread(new CantCatchDirectly(), "MyThread-1").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(), "MyThread-2").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(), "MyThread-3").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(), "MyThread-4").start();
        } catch (RuntimeException e) {
            System.out.println("Main Caught Exception.");
        }

    }

    @Override
    public void run() {
//        try {
            throw new RuntimeException();
//        } catch (RuntimeException e) {
//            System.out.println("RUN Caught Exception.");
//        }
    }
}
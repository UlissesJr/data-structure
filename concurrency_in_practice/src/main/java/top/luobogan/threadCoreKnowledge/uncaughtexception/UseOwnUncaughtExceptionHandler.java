package top.luobogan.threadCoreKnowledge.uncaughtexception;

/**
 * 使用刚才自己写的UncaughtExceptionHandler
 * Created by LuoboGan
 * Date:2022-09-25
 */
public class UseOwnUncaughtExceptionHandler implements Runnable {

    @SuppressWarnings("all")
    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("捕获器1"));

        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-1").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-2").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-3").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-4").start();
    }


    @Override
    public void run() {
        throw new RuntimeException();
    }
}
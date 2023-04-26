package top.luobogan.threadCoreKnowledge.threadObjectClassCommonMethods;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 描述： 每隔1秒钟输出当前时间，被中断，观察。
 * Thread.sleep()
 * TimeUnit.SECONDS.sleep()
 * Created by LuoboGan
 * Date:2022-09-24
 */
public class SleepInterrupted implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SleepInterrupted());
        thread.start();
        System.out.println(thread.getState()); // RUNNABLE
        Thread.sleep(6500);
        System.out.println(thread.getState()); // TIMED_WAITING
        thread.interrupt();
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Date());
            try {
                TimeUnit.HOURS.sleep(10);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("我被中断了！");
                e.printStackTrace();
            }
        }
    }
}


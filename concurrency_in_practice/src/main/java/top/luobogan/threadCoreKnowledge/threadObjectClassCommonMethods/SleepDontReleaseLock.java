package top.luobogan.threadCoreKnowledge.threadObjectClassCommonMethods;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示sleep不释放lock（lock需要手动释放）
 * Created by LuoboGan
 * Date:2022-09-24
 */
public class SleepDontReleaseLock implements Runnable {

    private static final Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        SleepDontReleaseLock sleepDontReleaseLock = new SleepDontReleaseLock();
        new Thread(sleepDontReleaseLock).start();
        new Thread(sleepDontReleaseLock).start();
    }

    @Override
    public void run() {
        LOCK.lock();
        try {
            System.out.println("线程" + Thread.currentThread().getName() + "获取到了锁");
            Thread.sleep(5000);
            System.out.println("线程" + Thread.currentThread().getName() + "已经苏醒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }
}

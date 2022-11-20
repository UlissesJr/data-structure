package top.luobogan.threadpool;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by LuoboGan
 * Date:2022/5/15
 */
public class TestLock {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try{
            // 业务代码
        }finally{
            lock.unlock();
        }
    }

}

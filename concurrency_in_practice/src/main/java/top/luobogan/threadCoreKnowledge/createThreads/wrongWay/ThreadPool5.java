package top.luobogan.threadCoreKnowledge.createThreads.wrongWay;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 采用线程池的方式创建线程
 * Created by LuoboGan
 * Date:2022-09-02
 */
public class ThreadPool5 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 100; i++){
            executorService.submit(new Task() {
            });
        }
    }
}

class Task implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}

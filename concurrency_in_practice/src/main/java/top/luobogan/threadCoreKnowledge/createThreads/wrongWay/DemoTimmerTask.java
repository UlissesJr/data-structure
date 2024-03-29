package top.luobogan.threadCoreKnowledge.createThreads.wrongWay;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器创建线程
 * Created by LuoboGan
 * Date:2022-09-02
 */
public class DemoTimmerTask {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },1000,1000);
    }


}

package top.luobogan.threadCoreKnowledge.threadObjectClassCommonMethods;

import org.junit.Test;
import top.luobogan.threadCoreKnowledge.utils.Print;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static top.luobogan.threadCoreKnowledge.utils.ThreadUtil.sleepSeconds;
import static top.luobogan.threadCoreKnowledge.utils.ThreadUtil.yieldThread;

/**
 * Created by LuoboGan
 * Date:2023-04-23
 */
public class YieldDemo {

    public static final int MAX_TURN = 100; //执行次数
    public static AtomicInteger index = new AtomicInteger(0); //执行编号

    // 记录线程的执行次数
    private static Map<String, AtomicInteger> metric = new HashMap<>();

    //输出线程的执行次数
    private static void printMetric() {
        Print.tco("metric = " + metric);
    }

    static class YieldThread extends Thread {
        static int threadSeqNumber = 1;

        public YieldThread() {
            super("YieldThread-" + threadSeqNumber);
            threadSeqNumber++;
            metric.put(this.getName(), new AtomicInteger(0));
        }

        public void run() {

            for (int i = 1; i < MAX_TURN && index.get() < MAX_TURN; i++) {
                Print.tco("线程优先级：" + getPriority());
                index.incrementAndGet();
                metric.get(this.getName()).incrementAndGet();
                if (i % 2 == 0) {
                    //让步：出让执行的权限
                      Thread.yield();
//                    yieldThread();

                }
            }
            //输出线程的执行次数
            printMetric();
            Print.tco(getName() + " 运行结束.");
        }
    }

    @Test
    public void test1() {
        Thread thread1 = new YieldThread();
        thread1.setPriority(Thread.MAX_PRIORITY);
        Thread thread2 = new YieldThread();
        thread2.setPriority(Thread.MIN_PRIORITY);
        Print.tco("启动线程.");
        thread1.start();
        thread2.start();
        sleepSeconds(100);
    }
}
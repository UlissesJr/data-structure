package top.luobogan.threadCoreKnowledge.stopThreads;

/**
 * 注意Thread.interrupted()方法的目标对象是“当前线程”，而不管本方法来自于哪个对象
 * Created by LuoboGan
 * Date:2022-09-20
 */
public class RightWayInterrupted {

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                }
            }
        });

        // 启动线程
        threadOne.start();
        //设置中断标志
        threadOne.interrupt();
        //获取中断标志不重置中断标志   true
        System.out.println("isInterrupted: " + threadOne.isInterrupted());
        //获取中断标志并重置中断标志   interrupted是静态方法，所以操作的是 MAIN线程 false
        System.out.println("isInterrupted: " + threadOne.interrupted());
        //获取当前线程（MAIN）的中断标志并重置中断标志     false
        System.out.println("isInterrupted: " + Thread.interrupted());
        //获取中断标志    true
        System.out.println("isInterrupted: " + threadOne.isInterrupted());
        threadOne.join();
        System.out.println("Main thread is over.");

    }
}


package top.luobogan.threadCoreKnowledge.createThreads.wrongWay;

/**
 * Created by LuoboGan
 * Date:2022-09-02
 */
public class LambdaThread {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();
    }

}

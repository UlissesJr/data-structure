package top.luobogan.threadCoreKnowledge.createThreads;

import top.luobogan.threadCoreKnowledge.utils.Print;

/**
 * Created by LuoboGan
 * Date:2023-04-21
 */
public class StackAreaDemo {
    public static void main(String args[]) throws InterruptedException {
        Print.cfo("当前线程名称：" + Thread.currentThread().getName());
        Print.cfo("当前线程ID：" + Thread.currentThread().getId());
        Print.cfo("当前线程状态：" + Thread.currentThread().getState());
        Print.cfo("当前线程优先级：" + Thread.currentThread().getPriority());
        int a = 1, b = 1;
        int c = a / b;
        anotherFun();
        Thread.sleep(10000000);
    }

    private static void anotherFun() {
        int a = 1, b = 1;
        int c = a / b;
        anotherFun2();
    }

    private static void anotherFun2() {
        int a = 1, b = 1;
        int c = a / b;
    }
}

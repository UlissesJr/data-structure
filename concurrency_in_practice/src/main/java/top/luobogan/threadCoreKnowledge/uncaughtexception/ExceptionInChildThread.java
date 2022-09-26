package top.luobogan.threadCoreKnowledge.uncaughtexception;

/**
 * 单线程，抛出，处理，有异常堆栈
 * 多线程，子线程发生异常，会有什么不同？
 * Created by LuoboGan
 * Date:2022-09-25
 */
public class ExceptionInChildThread implements Runnable {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        new Thread(new ExceptionInChildThread()).start();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
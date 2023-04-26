package top.luobogan.threadCoreKnowledge.createThreads;

/**
 * 采用Runnable方式创建线程
 * Created by LuoboGan
 * Date:2022-08-30
 */
public class RunnableStyle implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("用Runnable方法实现线程");
    }
}

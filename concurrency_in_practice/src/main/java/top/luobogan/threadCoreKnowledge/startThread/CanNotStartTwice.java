package top.luobogan.threadCoreKnowledge.startThread;

/**
 * 演示不能两次调用Start()方法，否则会报错
 * Created by LuoboGan
 * Date:2022-09-17
 */
public class CanNotStartTwice {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        thread.start();
        thread.start();

    }


}

package top.luobogan.threadCoreKnowledge.createThreads.wrongWay;

/**
 * 通过匿名内部类创建线程
 * Created by LuoboGan
 * Date:2022-09-02
 */
public class AnonymousInnerClassDemo {

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }

}

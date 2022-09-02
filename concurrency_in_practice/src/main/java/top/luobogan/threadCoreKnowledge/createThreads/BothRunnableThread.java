package top.luobogan.threadCoreKnowledge.createThreads;

/**
 * 同时实现了Runnable和Thread的接口
 * Created by LuoboGan
 * Date:2022-08-30
 */
public class BothRunnableThread {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来自Runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();

    }

}

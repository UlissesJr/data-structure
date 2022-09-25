package top.luobogan.threadCoreKnowledge.threadObjectClassCommonMethods;

/**
 * 演示join，注意语句输出顺序，会变化。
 * Created by LuoboGan
 * Date:2022-09-25
 */
public class Join {

    @SuppressWarnings("all")
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        });

        thread.start();
        thread2.start();
        System.out.println("开始等待子线程运行完毕");
        thread.join();
        thread2.join();
        //  主线程在等待子线程Join的时候，主线程处于waiting的状态
        System.out.println("所有子线程执行完毕");
    }
}


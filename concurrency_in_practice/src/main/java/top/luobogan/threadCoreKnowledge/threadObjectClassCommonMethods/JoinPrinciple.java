package top.luobogan.threadCoreKnowledge.threadObjectClassCommonMethods;

/**
 * 通过讲解join原理，分析出join的代替写法
 * Created by LuoboGan
 * Date:2022-09-25
 */
public class JoinPrinciple {

    @SuppressWarnings("all")
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "开始进行Sleep");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + "Sleep完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        });

        thread.start();
        System.out.println("开始等待子线程运行完毕");
//        thread.join();
        // Thread类比较特殊，他在执行完run方法后，会自动调用Notify（该调用过程为JVM控制）
        synchronized (thread) {
            System.out.println(Thread.currentThread().getName() + "开始wait");
            thread.wait();
            System.out.println(Thread.currentThread().getName() + "wait完毕");
        }
        System.out.println("所有子线程执行完毕");
    }

}

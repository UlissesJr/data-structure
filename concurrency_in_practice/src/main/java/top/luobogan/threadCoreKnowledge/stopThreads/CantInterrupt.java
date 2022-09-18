package top.luobogan.threadCoreKnowledge.stopThreads;

/**
 * 如果while里面放try/catch，会导致中断失效
 * sleep()方法在响应中断后，会把interrupted标记位清除
 * Created by LuoboGan
 * Date:2022-09-18
 */
public class CantInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }

}

package top.luobogan.threadCoreKnowledge;

/**
 * Created by LuoboGan
 * Date:2022/12/14
 */
public class jiandanxiexie implements Runnable{

    int a = 0 ;

    @Override
    public void run() {
        method();
    }

    private synchronized void method() {
        System.out.println("这是method, a = " + a);
        if(a == 0){
            a++;
            method2();
        }
    }

    private synchronized void method2() {
        System.out.println("这是method2, a = " + a);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new jiandanxiexie());
        thread1.start();
        while(thread1.isAlive()){
        }
        System.out.println("finished");
    }
}

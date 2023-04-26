package top.luobogan.threadCoreKnowledge.startThread;

public class SleepRelaseCPU {
    public static void main(String[] args) {

        for(int i = 0; i < 100; i++) {
            Thread thread = new Thread(new SubThread(),"Daemon Thread!"+i);
            thread.start();
        }
    }
    static class SubThread implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("FINISH!");
            }
        }
    }
}


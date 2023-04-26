package top.luobogan.threadCoreKnowledge.startThread;

public class ThreadDaemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonThread(),"Daemon Thread!");
        // 告诉我们，必须要先设置线程是否为守护线程，然后再调用start方法。如果你先调用start。
        thread.setDaemon(true); // 守护线程
        thread.start();
        // main 线程退出
    }
    static class DaemonThread implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally { //finally 不能够保证我们的守护线程的最终执行
                System.out.println("FINISH!");
            }
        }
    }
}


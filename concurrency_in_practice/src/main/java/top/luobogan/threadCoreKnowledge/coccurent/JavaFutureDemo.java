package top.luobogan.threadCoreKnowledge.coccurent;

import top.luobogan.threadCoreKnowledge.utils.Print;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import static top.luobogan.threadCoreKnowledge.coccurent.JoinDemo.getCurThreadName;

/**
 * Created by Oliveira
 */
public class JavaFutureDemo {

    public static final int SLEEP_GAP = 500;

    static class HotWaterJob implements Callable<Boolean> //①
    {
        @Override
        public Boolean call() throws Exception //②
        {
            try {
                Print.tcfo("洗好水壶");
                Print.tcfo("灌上凉水");
                Print.tcfo("放在火上");

                //线程睡眠一段时间，代表烧水中
                Thread.sleep(SLEEP_GAP);
                Print.tcfo("水开了");

            } catch (InterruptedException e) {
                Print.tcfo(" 发生异常被中断.");
                return false;
            }
            Print.tcfo(" 运行结束.");

            return true;
        }
    }

    static class WashJob implements Callable<Boolean> {
        @Override
        public Boolean call() throws Exception {
            try {
                Print.tcfo("洗茶壶");
                Print.tcfo("洗茶杯");
                Print.tcfo("拿茶叶");
                //线程睡眠一段时间，代表清洗中
                Thread.sleep(SLEEP_GAP);
                Print.tcfo("洗完了");

            } catch (InterruptedException e) {
                Print.tcfo(" 清洗工作 发生异常被中断.");
                return false;
            }
            Print.tcfo(" 清洗工作  运行结束.");
            return true;
        }
    }

    public static void drinkTea(boolean waterOk, boolean cupOk) {
        if (waterOk && cupOk) {
            Print.tcfo("泡茶喝");
        } else if (!waterOk) {
            Print.tcfo("烧水失败，没有茶喝了");
        } else if (!cupOk) {
            Print.tcfo("杯子洗不了，没有茶喝了");
        }
    }

    public static void main(String args[]) {
        Thread.currentThread().setName("主线程");
        Callable<Boolean> hJob = new HotWaterJob();//③
        FutureTask<Boolean> hTask =
                new FutureTask<>(hJob);//④
        Thread hotThread = new Thread(hTask, "** 烧水-Thread");//⑤

        Callable<Boolean> wJob = new WashJob();//③
        FutureTask<Boolean> wTask =
                new FutureTask<>(wJob);//④
        Thread washThread = new Thread(wTask, "$$ 清洗-Thread");//⑤
        hotThread.start();
        washThread.start();

        try {
            // get()方法会阻塞
            boolean waterOk = hTask.get();
            boolean cupOk = wTask.get();
            drinkTea(waterOk, cupOk);
        } catch (InterruptedException e) {
            Print.tcfo(getCurThreadName() + "发生异常被中断.");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Print.tcfo(getCurThreadName() + " 运行结束.");
    }
}
package top.luobogan.threadCoreKnowledge.designmodel.masterworker;

import top.luobogan.threadCoreKnowledge.utils.Print;
import top.luobogan.threadCoreKnowledge.utils.ThreadUtil;

import java.util.concurrent.TimeUnit;

public class MasterWorkerTest {
    //简单任务
    static class SimpleTask extends Task<Integer> {
        @Override
        protected Integer doExecute() {
            Print.tcfo("task " + getId() + " is done ");
            return getId();
        }
    }

    public static void main(String[] args) {
        //创建Master ，包含四个worker，并启动master的执行线程
        Master<SimpleTask, Integer> master = new Master<>(4);

        //定期向master提交任务
        ThreadUtil.scheduleAtFixedRate(() -> master.submit(
                new SimpleTask()),
                2, TimeUnit.SECONDS);

        //定期从master提取结果
        ThreadUtil.scheduleAtFixedRate(
                () -> master.printResult(),
                5, TimeUnit.SECONDS);
    }

}

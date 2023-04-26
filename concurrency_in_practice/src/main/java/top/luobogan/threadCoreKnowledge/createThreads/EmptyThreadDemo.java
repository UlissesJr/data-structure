package top.luobogan.threadCoreKnowledge.createThreads;

import top.luobogan.threadCoreKnowledge.utils.Print;
import top.luobogan.threadCoreKnowledge.utils.ThreadUtil;

/**
 * Created by LuoboGan
 * Date:2023-04-21
 */
public class EmptyThreadDemo {

    public static void main(String args[]) throws InterruptedException {
        //使用Thread类创建和启动线程
        Thread thread = new Thread();
        Print.cfo("线程名称：" + thread.getName());
        Print.cfo("线程ID：" + thread.getId());
        Print.cfo("线程状态：" + thread.getState());
        Print.cfo("线程优先级：" + thread.getPriority());
        thread.start();
        Print.cfo("线程状态：" + thread.getState());

        ThreadUtil.sleepMilliSeconds(10);
    }
}

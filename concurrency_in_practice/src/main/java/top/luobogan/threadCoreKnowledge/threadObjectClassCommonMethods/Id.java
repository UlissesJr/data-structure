package top.luobogan.threadCoreKnowledge.threadObjectClassCommonMethods;

/**
 * ID从0开始，JVM运行起来后，我们自己创建的线程的ID早已不是2.
 * Created by LuoboGan
 * Date:2022-09-25
 */
public class Id {

    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("主线程的ID"+Thread.currentThread().getId());
        System.out.println("子线程的ID"+thread.getId());
    }

}

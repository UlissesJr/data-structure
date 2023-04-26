package top.luobogan.JVM.classInit;

/**
 * Created by LuoboGan
 * Date:2023-04-01
 */
public class ConstantValueTest {
    public final static String NAME = "name";
    public final static int CODE = 200; // 我现在正处于编译期，代码并没有运行，CODE的200，和NAME的name 都已经被存储了，说明已然初始化完成；
    public static String INFO = "info";
    // 这个INFO没有constantValue，他需要在其他的时间点进行初始化，在<clinit>()方法中进行初始化；

    public final static Integer INTEGER = 110120;
}

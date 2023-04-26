package top.luobogan.JVM.classInit;

/**
 * Created by LuoboGan
 * Date:2023-03-31
 */
public class InitDemo {

    private static InitDemo initDemo = new InitDemo();

    private static int a = 0;
    private static int b;

    public InitDemo() {
        a ++ ;
        b ++ ;
    }

    public static InitDemo getInstance(){
        return initDemo;
    }

    public int getA(){
        return a;
    }

    public int getB() {
        return b;
    }

}

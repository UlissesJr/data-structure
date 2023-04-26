package top.luobogan;

/**
 * Created by LuoboGan
 * Date:2023/3/7
 */
public class StaticInnerTest {

    private int x = 1;
    private static int y = 2;

    public void test(){
        // 使用静态内部类对象访问其实例成员
        System.out.println(new InnerClass().a);
        // 使用静态内部类的类名作为调用者来访问静态内部类的类成员
        System.out.println(InnerClass.b);
    }

    static class InnerClass {
        private int a = 3;
        private static int b = 4;

        public void test(){
            //无法访问 静态内部类成员无法访问外部类的非静态成员
            //System.out.println(x);
            System.out.println(y);
        }
    }

    public static void main(String[] args) {
        StaticInnerTest staticInnerTest = new StaticInnerTest();
        staticInnerTest.test();

        InnerClass innerClass = new InnerClass();
        innerClass.test();
    }

}

package top.luobogan.creater.singleton;

/**
 * Created by LuoboGan
 * Date:2021/10/25
 */
public class MainTest {

    public static void main(String[] args) {

        // 懒汉式测试
        PersonLazy personLazy1 = PersonLazy.getInstance();
        PersonLazy personLazy2 = PersonLazy.getInstance();
        System.out.println(personLazy1 == personLazy2);

    }

}

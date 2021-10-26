package top.luobogan.creater.prototype;

/**
 * Created by LuoboGan
 * Date:2021/10/26
 * 用于创建重复的对象，同时又保证性能
 */
public class MainTest {

    public static void main(String[] args) {
        LuoboMybatis luoboMybatis = new LuoboMybatis();
        User luobogan = null;
        try {
            luobogan = luoboMybatis.getUser("luobogan");
            System.out.println(luobogan);
            luobogan.setAge(20);
            luobogan.setUsername("haha");
            User luobogan2 = luoboMybatis.getUser("luobogan");
            User luobogan3 = luoboMybatis.getUser("luobogan");
            User luobogan4 = luoboMybatis.getUser("luobogan");
            User luobogan5 = luoboMybatis.getUser("luobogan");
            System.out.println(luobogan);
            System.out.println(luobogan2);
            System.out.println(luobogan3);
            System.out.println(luobogan4);
            System.out.println(luobogan5);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}

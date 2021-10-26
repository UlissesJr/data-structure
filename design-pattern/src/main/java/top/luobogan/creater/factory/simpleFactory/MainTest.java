package top.luobogan.creater.factory.simpleFactory;

/**
 * Created by LuoboGan
 * Date:2021/10/26
 */
public class MainTest {

    public static void main(String[] args) {

        WuLingSimpleFactory factory = new WuLingSimpleFactory();
        AbstractCar mini = factory.newCar("mini");
        mini.run();
        AbstractCar van = factory.newCar("van");
        van.run();
    }

}

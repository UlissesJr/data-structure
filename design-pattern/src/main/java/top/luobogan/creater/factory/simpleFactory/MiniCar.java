package top.luobogan.creater.factory.simpleFactory;

/**
 * Created by LuoboGan
 * Date:2021/10/27
 */
public class MiniCar extends AbstractCar{

    MiniCar(){
        this.engine = "双杠发动机";
    }


    @Override
    public void run() {
        System.out.println(engine+"---->>>噗噗噗");
    }
}

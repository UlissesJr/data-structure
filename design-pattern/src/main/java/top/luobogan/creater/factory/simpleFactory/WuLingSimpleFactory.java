package top.luobogan.creater.factory.simpleFactory;

/**
 * Created by LuoboGan
 * Date:2021/10/26
 * 简单工厂，产品数量极少
 */
public class WuLingSimpleFactory {

    public AbstractCar newCar(String type){

        /*
        * 核心方法：一切从简
        * 问题：更多的产品违反开闭原则，应该直接扩展出一个类来造
        */
        if("van".equals(type)){
            return new VanCar();
        }else if ("mini".equals(type)){
            return new MiniCar();
        }else{
            return null;
        }
    }
}

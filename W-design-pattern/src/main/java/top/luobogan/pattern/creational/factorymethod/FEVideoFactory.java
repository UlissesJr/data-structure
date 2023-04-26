package top.luobogan.pattern.creational.factorymethod;

/**
 * Created by luobogan
 */
public class FEVideoFactory extends VideoFactory{
    @Override
    public Video getVideo() {
        return new FEVideo();
    }
}

package top.luobogan.pattern.creational.factorymethod;

/**
 * Created by luobogan
 */
public class JavaVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}

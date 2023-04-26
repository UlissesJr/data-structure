package top.luobogan.pattern.creational.factorymethod;

/**
 * Created by luobogan
 */
public class PythonVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}

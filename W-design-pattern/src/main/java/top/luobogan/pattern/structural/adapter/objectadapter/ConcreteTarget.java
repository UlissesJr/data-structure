package top.luobogan.pattern.structural.adapter.objectadapter;


/**
 * Created by luobogan
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("concreteTarget目标方法");
    }

}

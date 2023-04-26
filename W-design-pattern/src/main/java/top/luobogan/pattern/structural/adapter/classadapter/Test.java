package top.luobogan.pattern.structural.adapter.classadapter;

/**
 * Created by luobogan
 */
public class Test {
    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();



    }
}

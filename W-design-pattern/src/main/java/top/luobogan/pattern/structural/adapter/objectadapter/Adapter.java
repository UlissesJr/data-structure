package top.luobogan.pattern.structural.adapter.objectadapter;

/**
 * Created by luobogan
 */
public class Adapter implements Target{
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        //...
        adaptee.adapteeRequest();
        //...
    }
}

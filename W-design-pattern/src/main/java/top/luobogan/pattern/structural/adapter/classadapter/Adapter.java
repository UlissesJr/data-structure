package top.luobogan.pattern.structural.adapter.classadapter;

/**
 * Created by luobogan
 */
public class Adapter extends Adaptee implements Target{
    @Override
    public void request() {
        //...
        super.adapteeRequest();
        //...
    }
}

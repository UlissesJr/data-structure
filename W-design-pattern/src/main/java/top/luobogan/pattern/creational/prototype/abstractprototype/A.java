package top.luobogan.pattern.creational.prototype.abstractprototype;

/**
 * Created by luobogan
 */
public abstract class A implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

package top.luobogan.principle.liskovsubstitution.methodinput;

import java.util.HashMap;

/**
 * Created by luobogan
 */
public class Test {
    public static void main(String[] args) {
        Base child = new Child();
        HashMap hashMap = new HashMap();
        child.method(hashMap);
    }
}

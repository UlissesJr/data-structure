package top.luobogan.JVM;

import top.luobogan.JVM.classInit.InitDemo;

/**
 * Created by LuoboGan
 * Date:2023/3/27
 */
public class Demo {

    public static void main(String[] args) throws ClassNotFoundException {

        ClassLoader.getSystemClassLoader().loadClass("top.luobogan.JVM.Demo");

        InitDemo instance =  InitDemo.getInstance();
        System.out.println("initDemo.getA()=="+instance.getA()); // 0
        System.out.println("initDemo.getB()=="+instance.getB()); // 1

    }

}

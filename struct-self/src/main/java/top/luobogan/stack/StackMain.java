package top.luobogan.stack;

import java.util.Stack;

/**
 * Created by LuoboGan
 * Date:2022/11/19
 */
public class StackMain {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        boolean contains = stack.contains(2);
        System.out.println(contains);


    }

}

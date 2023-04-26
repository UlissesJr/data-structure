package top.luobogan.JUC.collections.predecessor;

import java.util.HashMap;

/**
 * 演示 HashMap 在多线程情况下造成死循环的情况
 * Created by LuoboGan
 * Date:2023-04-25
 */
public class HashMapEndlessLoop {

    private static HashMap<Integer,String> map = new HashMap<>(2,1.5f);

    public static void main(String[] args) {
        map.put(5,"C"); // 只有两个槽，key设置为3 5 7 等奇数可以做到让Hash值落到固定的槽里;
        map.put(7,"B");
        map.put(3,"A");
        // 3个值还不会触发扩容，我们来新建下一个
        new Thread(new Runnable() {
            @Override
            public void run() {
                map.put(15,"D");
                System.out.println(map);
            }
        },"Thread 1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                map.put(1,"E");
                System.out.println(map);
            }
        },"Thread 2").start();
    }
}

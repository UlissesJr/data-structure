package top.luobogan.JUC.collections.copyonwrite;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 描述：     对比两个迭代器
 */
public class CopyOnWriteArrayListDemo2 {

    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>(new Integer[]{1, 2, 3});

        System.out.println(list); //[1, 2, 3]

        Iterator<Integer> itr1 = list.iterator();

        list.remove(2);
        Thread.sleep(1000);
        System.out.println(list); // [1, 2]

        Iterator<Integer> itr2 = list.iterator();

        itr1.forEachRemaining(System.out::println); // 1 2 3
        itr2.forEachRemaining(System.out::println); // 1 2
    }
}

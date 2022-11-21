package top.luobogan.linear.queue;

import top.luobogan.linear.List.LinkedList;
import top.luobogan.linear.List.List;

/**
 * Created by LuoboGan
 * Date:2022/11/19
 */
public class Queue<E> {
    private List<E> list = new LinkedList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public void enQueue(E element) {
        list.add(element);
    }

    public E deQueue() {
        return list.remove(0);
    }

    public E front() {
        return list.get(0);
    }
}


package top.luobogan.stack;

import top.luobogan.List.ArrayList;
import top.luobogan.List.List;

/**
 * Created by LuoboGan
 * Date:2022/11/19
 */
public class Stack<E> {
    private List<E> list = new ArrayList<>();

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E element) {
        list.add(element);
    }


    public E pop() {
        return list.remove(list.size() - 1);
    }


    public E top() {
        return list.get(list.size() - 1);
    }
}


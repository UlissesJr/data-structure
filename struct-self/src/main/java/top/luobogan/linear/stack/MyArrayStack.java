package top.luobogan.linear.stack;

import top.luobogan.linear.List.MyArrayList;

import java.util.NoSuchElementException;

public class MyArrayStack<E> {

    private MyArrayList<E> arr = new MyArrayList<>();

    public void push(E e) {
        arr.addLast(e);
    }

    public E pop() {
        return arr.removeLast();
    }

    public E peek() {
        if (arr.isEmpty()) {
            throw new NoSuchElementException();
        }
        return arr.get(arr.size() - 1);
    }

}

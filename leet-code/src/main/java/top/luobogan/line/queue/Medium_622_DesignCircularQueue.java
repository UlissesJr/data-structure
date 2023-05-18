package top.luobogan.line.queue;

import java.util.NoSuchElementException;

/**
 * https://leetcode.cn/problems/design-circular-queue/
 * 设计循环队列
 */
public class Medium_622_DesignCircularQueue<E> {

    // size为queue里实际的元素个数
    private int size;
    private int[] data;
    private final static int INIT_CAP = 2;

    // 左闭右开区间
    private int first, last;

    public Medium_622_DesignCircularQueue() {
        // 不传参数，默认大小为 INIT_CAP
        this(INIT_CAP);
    }

    /**
     * 构造器，设置队列长度为 k
     */
    public Medium_622_DesignCircularQueue(int k) {
        size = 0;
        data = new int[k];
        first = last = 0;
    }

    /**
     * 向循环队列插入一个元素。如果成功插入则返回真
     */
    public boolean enQueue(int value) {

        if(size >= data.length ){
            return false;
        }

        data[last] = value;
        size++;
        last++;
        if(last == data.length){
            last = 0;
        }
        return true;
    }

    /**
     * 从循环队列中删除一个元素。如果成功删除则返回真
     */
    public boolean deQueue() {

        // 判空
        if(isEmpty()){
            // 运行时异常，不需要捕获；
            return false;
        }

        size--;
        first++;
        if(first == data.length){
            first = 0;
        }
        return true;
    }

    /**
     * 从队首获取元素。如果队列为空，返回 -1
     */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return data[first];
    }

    /**
     * 获取队尾元素。如果队列为空，返回 -1
     */
    public int Rear() {

        if(isEmpty()){
            return -1;
        }

        if(last == 0){
            return data[data.length-1];
        }

        return data[last-1];
    }

    /**
     * 检查循环队列是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 检查循环队列是否已满
     */
    public boolean isFull() {
        return size == data.length;
    }

}

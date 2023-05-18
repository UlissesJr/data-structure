package top.luobogan.line.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/moving-average-from-data-stream/
 * 数据流中的移动平均值
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。
 */
public class Easy_346_MovingAverageFromDataStream {

    private int slideSize;

    private int sum = 0;

    private Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {

    }

    public Easy_346_MovingAverageFromDataStream(int size){
        this.slideSize = size;
    }

    public double next(int val) {
        queue.offer(val);
        sum += val;

        // 维护定长队列，SUM, count
        if(queue.size() > slideSize){
            Integer delVal = queue.peek();
            queue.poll();
            sum -= delVal;
        }

        return (double)sum/queue.size();
    }
}

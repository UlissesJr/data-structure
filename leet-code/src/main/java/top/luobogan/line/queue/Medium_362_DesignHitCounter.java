package top.luobogan.line.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/design-hit-counter/
 * 敲击计数器
 * 设计一个敲击计数器，使它可以统计在过去 5 分钟内被敲击次数。（即过去 300 秒）
 */
public class Medium_362_DesignHitCounter {
    Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {

    }

    public void hit(int timestamp) {
        q.offer(timestamp);
    }

    /**
     * 题目说了 getHits 查询的 timestamp 是递增的
     * 所以每个 getHits 时保留队列中最近 300 秒的数据即可，其他数据均可删除。
     */
    public int getHits(int timestamp) {
        // 留队列中最近 300 秒的数据即可
        while (!q.isEmpty() && timestamp - q.peek() >= 300) {
            q.poll();
        }
        return q.size();
    }

}

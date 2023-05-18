package top.luobogan.line.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/number-of-recent-calls/
 * 最近的请求次数
 */
public class Easy_933_NumberOfRecentCalls {

    Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Easy_933_NumberOfRecentCalls obj = new Easy_933_NumberOfRecentCalls();
        int param_1 = obj.ping(200);
    }

    public int ping(int t) {
        queue.offer(t);
        // 将3000毫秒以外的数据删除
        while (!queue.isEmpty() && t - queue.peek() >= 3000) {
            queue.poll();
        }
        return queue.size();
    }
}

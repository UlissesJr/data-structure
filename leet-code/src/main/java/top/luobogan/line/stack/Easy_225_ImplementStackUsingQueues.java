package top.luobogan.line.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/implement-stack-using-queues/
 * 用队列实现栈
 * 底层队列只能向队尾添加元素，所以栈的 pop API 相当于要从队尾取元素：
 */
public class Easy_225_ImplementStackUsingQueues {

    Queue<Integer> q = new LinkedList<>();
    int top_elem = 0;

    public static void main(String[] args) {
        Easy_225_ImplementStackUsingQueues obj = new Easy_225_ImplementStackUsingQueues();
        obj.push(1);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
    }

    public Easy_225_ImplementStackUsingQueues() {

    }

    public void push(int x) {
        // x 是队列的队尾，是栈的栈顶
        q.offer(x);
        top_elem = x;
    }

    /**
     * 删除栈顶的元素并返回
     */
    public int pop() {
        int size = q.size();
        // 留下队尾 2 个元素
        while (size > 2) {
            q.offer(q.poll());
            size--;
        }
        // 记录新的队尾元素
        top_elem = q.peek();
        q.offer(q.poll());
        // 删除之前的队尾元素
        return q.poll();
    }

    /**
     * 返回栈顶元素
     */
    public int top() {
        return top_elem;
    }

    /**
     * 判断栈是否为空
     */
    public boolean empty() {
        return q.isEmpty();
    }

}

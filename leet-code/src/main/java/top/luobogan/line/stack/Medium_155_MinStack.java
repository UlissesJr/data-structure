package top.luobogan.line.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/min-stack/
 * 最小栈
 * 删除栈顶元素的时候，不确定新的最小值是多少，但楼下那哥们知道啊，他当时入栈时的最小值，就是现在的最小值呗。
 * 关键就是，每个元素入栈时，还要记下来当前栈中的最小值。
 * 可以用一个额外的栈 minStk 来记录栈中每个元素入栈时的栈中的最小元素是多少
 */
public class Medium_155_MinStack {

    // 记录栈中的所有元素
    Stack<Integer> stk = new Stack<>();
    // 阶段性记录栈中的最小元素
    Stack<Integer> minStk = new Stack<>();

    public static void main(String[] args) {
        Medium_155_MinStack obj = new Medium_155_MinStack();
        obj.push(1);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }

    public Medium_155_MinStack() {

    }

    /**
     * 将元素val推入堆栈
     * @param val
     */
    public void push(int val) {

        Integer minValue = minStk.peek();
        // 维护 minStk 栈顶为全栈最小元素
        if(minStk.isEmpty() || val <= minValue ){
            // 新插入的这个元素就是全栈最小的
            minStk.push(val);
        }else {
            // 插入的这个元素比较大
            minStk.push(minValue);
        }
        stk.push(val);
    }

    /**
     * 删除堆栈顶部的元素
     */
    public void pop() {
        stk.pop();
        minStk.pop();
    }

    /**
     * 获取堆栈顶部的元素
     */
    public int top() {
        return stk.peek();
    }

    /**
     * 获取堆栈中的最小元素
     */
    public int getMin() {
        // minStk 栈顶为全栈最小元素
        return minStk.peek();
    }


}

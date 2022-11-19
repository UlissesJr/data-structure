package top.luobogan.line.queue;

import java.util.Stack;

/**
 * Created by LuoboGan
 * Date:2022/11/19
 * 1 <= x <= 9
 * 最多调用 100 次 push、pop、peek 和 empty
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 */
public class Code_232_ImplementQueueUsingStacks {

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */

    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    public Code_232_ImplementQueueUsingStacks() {

    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {

        if(outStack.isEmpty()){
            // 这里 for循环为什么错了？ 因为inStack pop 之后 inStack.size() 变小了，因此条件不能写在循环里；
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }

        return outStack.pop();
    }

    public int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }

        return outStack.peek();
    }

    // 错误的写法，for循环中inStack.size() 是变化的；
//    public int pop() {
//        if(outStack.isEmpty()){
//            for(int i = 0 ; i < inStack.size(); i++){
//                outStack.push(inStack.pop());
//            }
//            return outStack.pop();
//        }else{
//            return outStack.pop();
//        }
//    }

//    public int peek() {
//        if(outStack.isEmpty()){
//            for(int i = 0 ; i < inStack.size(); i++){
//                outStack.push(inStack.pop());
//            }
//            return outStack.peek();
//        }else{
//            return outStack.peek();
//        }
//    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }


}

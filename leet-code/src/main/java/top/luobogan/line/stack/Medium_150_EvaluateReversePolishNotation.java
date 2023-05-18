package top.luobogan.line.stack;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 * 逆波兰表达式求值
 */
public class Medium_150_EvaluateReversePolishNotation {

    public static void main(String[] args) {

    }

    /**
     * 按顺序遍历逆波兰表达式中的字符，如果是数字，则放入栈；
     * 如果是运算符，则将栈顶的两个元素拿出来进行运算，再将结果放入栈。
     * 对于减法和除法，运算顺序别搞反了，栈顶第二个数是被除（减）数。
     */
    public int evalRPN(String[] tokens) {

        Stack<Integer> stk = new Stack<>();

        for(String token : tokens){
            // 如果是运算符，则从栈中取出数据，进行计算，将结果压栈
            if ("+-*/".contains(token)){
                int a = stk.pop(), b = stk.pop();
                switch (token) {
                    case "+":
                        stk.push(a + b);
                        break;
                    case "*":
                        stk.push(a * b);
                        break;
                    // 对于减法和除法，顺序别搞反了，第二个数是被除（减）数
                    case "-":
                        stk.push(b - a);
                        break;
                    case "/":
                        stk.push(b / a);
                        break;
                }
            }else {
                stk.push(Integer.parseInt(token));
            }
        }
        // 最后栈中剩下一个数字，即是计算结果
        return stk.pop();
    }
}

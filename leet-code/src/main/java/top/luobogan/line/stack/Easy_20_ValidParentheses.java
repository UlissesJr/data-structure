package top.luobogan.line.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-parentheses/
 * 有效的括号
 * 遇到左括号就入栈，遇到右括号就去栈中寻找最近的左括号，看是否匹配。
 * Created by LuoboGan
 * Date:2022/11/19
 */
public class Easy_20_ValidParentheses {

    private static HashMap<Character,Character> map = new HashMap<>();

    static {
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
    }

    public static void main(String[] args) {

    }

    // 解法一: 将字符串进行替换
    // contains 与 replace 消耗性能，且字符串为不可变类型，消耗内存
//    public boolean isValid(String s) {
//
//        while (s.contains("{}")
//                || s.contains("[]")
//                || s.contains("()")) {
//            s = s.replace("{}","");
//            s = s.replace("[]","");
//            s= s.replace("()","");
//        }
//
//        return s.isEmpty();
//    }

    public boolean isValid(String str) {
        Stack<Character> left = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                left.push(c);
            else // 字符 c 是右括号
                if (!left.isEmpty() && leftOf(c) == left.peek())
                    left.pop();
                else
                    // 和最近的左括号不匹配
                    return false;
        }
        // 是否所有的左括号都被匹配了
        return left.isEmpty();
    }

    char leftOf(char c) {
        if (c == '}') return '{';
        if (c == ')') return '(';
        return '[';
    }

    /**
     * 解法二，使用栈
     */
    public boolean isValid2(String s) {

        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for(int i = 0; i < length ; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }

                Character left = stack.pop();
                if(c != map.get(left)){
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }
}

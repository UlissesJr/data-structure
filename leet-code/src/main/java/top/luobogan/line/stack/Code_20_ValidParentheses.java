package top.luobogan.line.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-parentheses/
 * 有效的括号
 * Created by LuoboGan
 * Date:2022/11/19
 */
public class Code_20_ValidParentheses {

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


    /**
     * 解法二，使用栈
     */
    public boolean isValid(String s) {

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

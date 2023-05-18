package top.luobogan.line.stack;

/**
 * https://leetcode.cn/problems/minimum-insertions-to-balance-a-parentheses-string/
 * 平衡括号字符串的最少插入次数
 */
public class Medium_1541_MinimumInsertionsToBalanceAParenthesesString {

    public static void main(String[] args) {

    }

    public int minInsertions(String s) {
        // need 记录需右括号的需求量
        int res = 0, need = 0;

        for (int i = 0; i < s.length(); i++) {
            // 一个左括号对应两个右括号
            if (s.charAt(i) == '(') {
                need += 2;
            }

            if (s.charAt(i) == ')') {
                need--;
            }
        }

        return res + need;
    }


}

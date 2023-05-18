package top.luobogan.line.stack;

/**
 * https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/
 * 使括号有效的最少添加
 * 核心思路是以左括号为基准，通过维护对右括号的需求数 need，来计算最小的插入次数。
 */
public class Medium_921_MinimumAddToMakeParenthesesValid {

    public static void main(String[] args) {

    }

    /**
     * 1、当 need == -1 的时候意味着什么？
     * 因为只有遇到右括号 ) 的时候才会 need--，need == -1 意味着右括号太多了，所以需要插入左括号。
     * 比如说 s = "))" 这种情况，需要插入 2 个左括号，使得 s 变成 "()()"，才是一个有效括号串。
     *
     * 2、算法为什么返回 res + need？
     * 因为 res 记录的左括号的插入次数，need 记录了右括号的需求，当 for 循环结束后，若 need 不为 0，那么就意味着右括号还不够，需要插入。
     * 比如说 s = "))(" 这种情况，插入 2 个左括号之后，还要再插入 1 个右括号，使得 s 变成 "()()()"，才是一个有效括号串。
     */
    public int minAddToMakeValid(String S) {
        // 记录插入次数
        int res = 0;
        // 变量记录右括号的需求量
        int need = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                // 对右括号的需求 + 1
                need++;
            }

            if (S.charAt(i) == ')') {
                // 对右括号的需求 - 1
                need--;

                if (need == -1) {
                    need = 0;
                    // 需插入一个左括号
                    res++;
                }
            }
        }
        // 插入剩余所需的右括号
        return res + need;
    }
}

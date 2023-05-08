package top.luobogan.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-window-substring/
 * 滑动窗口
 * Created by LuoboGan
 * Date:2023/3/4
 */
public class Hard_76_minimumWindowSubstring {

    /**
     * 解题思路：
     * 1 我们在字符串 S 中使用双指针中的左右指针技巧，初始化 left = right = 0，把索引左闭右开区间 [left, right) 称为一个「窗口」。
     * 2 我们先不断地增加 right 指针扩大窗口 [left, right)，直到窗口中的字符串符合要求（包含了 T 中的所有字符）。
     * 3 此时，我们停止增加 right，转而不断增加 left 指针缩小窗口 [left, right)，
     * 直到窗口中的字符串不再符合要求（不包含 T 中的所有字符了）。同时，每次增加 left，我们都要更新一轮结果。
     * 4 重复第 2 和第 3 步，直到 right 到达字符串 S 的尽头。
     *
     * 这个思路其实也不难，第 2 步相当于在寻找一个「可行解」，然后第 3 步在优化这个「可行解」，最终找到最优解.
     */

    /**
     * needs 和 window 相当于计数器，分别记录 T 中字符出现次数和「窗口」中的相应字符的出现次数。
     *
     * 1、什么时候应该移动 right 扩大窗口？窗口加入字符时，应该更新哪些数据？
     * 2、什么时候窗口应该暂停扩大，开始移动 left 缩小窗口？从窗口移出字符时，应该更新哪些数据？
     * 3、我们要的结果应该在扩大窗口时还是缩小窗口时进行更新？
     *
     * 如果一个字符进入窗口，应该增加 window 计数器；如果一个字符将移出窗口的时候，应该减少 window 计数器；
     * 当 valid 满足 need 时应该收缩窗口；应该在收缩窗口的时候更新最终结果。
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        // 先将need补充完毕
        for(int i = 0; i< t.length(); i++){
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;
        // valid 变量表示窗口中满足 need 条件的字符个数
        // 如果 valid 和 need.size 的大小相同，则说明窗口已满足条件，已经完全覆盖了串 T。
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 说明 字符C 已经满足条件了，value++
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                // 因为是左闭右开，所以相减就是长度
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 1) - 1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ?
                "" : s.substring(start, start+len);
    }

}

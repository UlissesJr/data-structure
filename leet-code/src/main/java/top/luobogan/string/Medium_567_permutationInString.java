package top.luobogan.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/permutation-in-string/
 * Created by LuoboGan
 * Date:2023/3/4
 */
public class Medium_567_permutationInString {

    /**
     * 本题移动 left 缩小窗口的时机是窗口大小大于 t.size() 时，因为排列嘛，显然长度应该是一样的。
     * 当发现 valid == need.size() 时，就说明窗口中就是一个合法的排列，所以立即返回 true。
     * note：这道题中 [left, right) 其实维护的是一个定长的窗口，窗口大小为 t.size()。
     */

    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "eidabaooo";

        boolean b = checkInclusion(s1, s2);
        System.out.println(b);

    }

    // 判断s2 是否包含 s1
    // 注意哦，输入的 s1 是可以包含重复字符的
    public static boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;
        // valid 变量表示窗口中满足 need 条件的字符个数
        // 如果 valid 和 need.size 的大小相同，则说明窗口已满足条件，已经完全覆盖了串 T。
        int valid = 0;

        while (right < s2.length()) {
            // c 是将移入窗口的字符
            char c = s2.charAt(right);
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
            // 这一步判断很关键 (right - left) >= s1.length()
            while ((right - left) >= s1.length()) {
                // 判断是否得到了合法的字符串
                if (valid == need.size()) {
                    return true;
                }

                // d 是将移出窗口的字符
                char d = s2.charAt(left);
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
        return false;
    }

}

package top.luobogan.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LuoboGan
 * Date:2023/3/5
 */
public class Medium_3_longestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int res = 0;

        while(right < s.length()){
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            while(window.get(c) > 1){
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                window.put(d, window.getOrDefault(d, 1) - 1);
            }

            res = Math.max(res,right-left);
        }

        return res;

    }

}
package top.luobogan.array;

/**
 * https://leetcode.cn/problems/reverse-string/
 * Created by LuoboGan
 * Date:2023/2/28
 */
public class Code_344_reverseString {

    public static void main(String[] args) {

        char[] chars = new char[]{'a','b','c','d','l'};

    }

    public static void reverseString(char[] s) {

        int left = 0 , right = s.length-1 ;
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left ++;
            right --;
        }
    }

}

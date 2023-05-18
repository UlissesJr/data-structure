package top.luobogan.string;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/roman-to-integer/
 * 罗马数字转整数
 */
public class Easy_13_RomanToInteger {

    private static HashMap<String,Integer> numIcons = new HashMap<>(13);

    static {
        numIcons.put("I",1);
        numIcons.put("V",5);
        numIcons.put("IV",4);
        numIcons.put("X",10);
        numIcons.put("IX",9);
        numIcons.put("L",50);
        numIcons.put("XL",40);
        numIcons.put("C",100);
        numIcons.put("XC",90);
        numIcons.put("D",500);
        numIcons.put("CD",400);
        numIcons.put("M",1000);
        numIcons.put("CM",900);
    }

    public static void main(String[] args) {
        romanToInt("");
    }

    public static int romanToInt(String s) {

        int length = s.length();
        int result = 0;
        int step = 0;
        // 先走两步，再走一步，一步一步来；
        while(step < length ){

            if(step + 1 < length){
                String want = s.charAt(step) + "" + s.charAt(step + 1);
                if(numIcons.containsKey(want)){
                    Integer a = numIcons.get(want);
                    result += a;
                    step = step + 2;
                }else{
                    Integer a = numIcons.get(s.charAt(step) + "");
                    result += a;
                    step = step + 1;
                }
            }else{
                Integer a = numIcons.get(s.charAt(step) + "");
                result += a;
                step = step + 1;
            }

        }
        return result;
    }

}

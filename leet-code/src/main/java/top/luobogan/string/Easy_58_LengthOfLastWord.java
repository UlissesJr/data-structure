package top.luobogan.string;

/**
 * https://leetcode.cn/problems/length-of-last-word/
 * 最后一个单词的长度
 */
public class Easy_58_LengthOfLastWord {

    public static void main(String[] args) {

        int i = lengthOfLastWord("   fly me   to   the moon  ");
        System.out.println(i);

    }

    public static int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");

        int length = strings.length;
        for(int i = length-1 ; i >= 0 ; i--){
            String string = strings[i];
            string = string.replace(" ","");
            int strLength = string.length();
            if(strLength > 0){
                return strLength;
            }
        }

        return 1 ;
    }

}

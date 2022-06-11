package top.luobogan.array;

/**
 * Created by LuoboGan
 * Date:2022/6/11
 * 数组：实现整数的数字反转
 * 题目来源：https://leetcode-cn.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public static void main(String[] args) {

    }

    /**
     * 解法一，暴力解法 思路：
     * 1.整数转字符串，再转字符数组
     * 2.反向遍历字符数组，并将元素存储到新数组中
     * 3.将新数组转成字符串，再转成整数输出
     * ** 注意事项：
     * 边界问题
     * 数组索引越界
     * 数值溢出边界：溢出则返回0
     * 细节问题
     * 首位不为0
     * 符号处理
     */
    public int reverseRude(int x) {
        if (x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) {
            // 整数类型的最小值的绝对值 比 最大值的绝对值 大1
            return 0;
        }

        int sign = x > 0 ? 1 : -1; // 符号
        x = x < 0 ? -x : x; // 无论正负，都当成正数

        // 1.整数转字符串，再转字符数组
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();

        // 2.反向遍历字符数组，并将元素存储到新数组中
        int len = chars.length;
        char[] array = new char[len];
        // for (int i = len - 1; i >= 0; i--) { // 遍历原数组
        // array[len - 1 - i] = chars[i];
        // }
        for (int i = 0; i < len; i++) {
            // 遍历新数组
            array[i] = chars[len - 1 - i];
        }
        // 3.将新数组转成字符串，再转成整数输出
        // Integer result = Integer.valueOf(String.valueOf(array));
        long value = Long.valueOf(String.valueOf(array));
        boolean b = value > Integer.MAX_VALUE || value < Integer.MIN_VALUE;
        int result = b ? 0 : (int) value; // 数值越界：溢出则返回0
        return result * sign;
    }

    /**
     * 解法二，优化解法 思路：
     * 1.整数转字符串，再转字符数组
     * 2.交换首位(start)和末位(end)数字
     * 3.循环操作：依次交换第二(start++)和倒数第二个(end--)  直到数组剩下1个或0个元素
     * 4.将原数组转成字符串，再转成整数输出
     * 注意事项：
     * 边界问题
     * 数组索引越界：数组长度为偶数，反转完成标志为start>end；
     * 为奇数时反转完成标志为start==end
     * 数值溢出边界：溢出则返回0
     * 细节问题
     * 首位不为0
     * 符号处理
     */
    public int reverseExchange(int x) {
        if (x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) {
            // 整数类型的最小值的绝对值 比 最大值的绝对值 大1
            return 0;
        }
        int sign = x > 0 ? 1 : -1; // 符号
        x = x < 0 ? -x : x;  // 无论正负，都当成正数

        // 1.整数转字符串，再转字符数组
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();

        // 2.交换首位(start)和末位(end)数字
        // 3.循环操作：依次交换第二(start++)和倒数第二个(end--)
        int start = 0, end = chars.length - 1;
        while (start < end) { // 反转完成的标志：start >= end
            // 交换两端等距离的元素
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        // 4.将原数组转成字符串，再转成整数输出
        long value = Long.parseLong(String.valueOf(chars));
        boolean b = value > Integer.MAX_VALUE || value < Integer.MIN_VALUE;
        int result = b ? 0 : (int) value;
        return result * sign;
    }

    /**
     * 最优解法 数学解法思路：
     * 1.尝试拿个位数字 * 对10取模运算得到个位数字
     * 2.让每一位数字变成个位数字
     * 先除以10，再对10取模得到十位数字
     * 循环上述操作
     * 3.将每一位数字计算累加
     * 将上次累加结果*10 + 新数字
     * 注意事项：
     * 边界问题：
     * 从低位到高位处理，最高位结束
     * 最高位 / 10 == 0
     * 最高位 % 10 == 最高位
     * 数值溢出边界：溢出则返回0
     * 用long类型存放，溢出int则返回0
     * 新整数补充最后一位前判断溢出
     * 细节问题：
     * 首位不为0
     * 符号处理
     */
    public int reverseBest(int x) {
        if (x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) {
            // 整数类型的最小值的绝对值 比 最大值的绝对值 大1
            return 0;
        }
        int sign = x > 0 ? 1 : -1;// 符号
        x = x < 0 ? -x : x; // 无论正负，都当成正数
        int result = 0; // 返回结果

        // 1.尝试拿个位数字：对10取模运算
        // 2.让每一位数字变成个位数字：先除以10，再对10取模得到十位数字
        int last = 0; // 末位
        while ((last = x % 10) != x) {
            // 3.将每一位数字计算累加：将上次累加结果*10 + 新数字
            result = result * 10 + last;
            x /= 10;
        }
        if (last != 0) { // 此时last是最高位，单独处理
            long re = result;
            re = re * 10 + last;
            if (re > Integer.MAX_VALUE || re < Integer.MIN_VALUE) {
                result = 0;
            } else {
                result = (int) re;
            }
        }
        return result * sign; // 返回前进行符号处理
    }

}
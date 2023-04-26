package top.luobogan.array;

/**
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 * 长度最小的子数组
 * Created by LuoboGan
 * Date:2023/2/8
 */
public class Code_209_minimumSizeSubarraySum {

    public static void main(String[] args) {
        int[] nums = {1,2,4,3,4,6};
        int search = minSubArrayLen2(7, nums);
        System.out.println(search);

    }

    /**
     * 给定一个含有n个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
     * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
     */
    // 暴力解法
    public static int minSubArrayLen(int target, int[] nums) {

        int result = Integer.MAX_VALUE; // 最终的结果
        int sum = 0; // 子数组之和
        int subLength = 0; // 子数组的长度

        for(int i = 0 ; i < nums.length ; i++){ // 子数组起始位置
            sum = 0;
            for(int j = i; j < nums.length ; j++){ // 子数组终止位置
                sum += nums[j];
                if(sum >= target){
                    subLength = j - i + 1;
                    result = Math.min(result, subLength);
                    break;
                }
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    /**
     * 滑动窗口
     */
    public static int minSubArrayLen2(int target, int[] nums) {

        int result = Integer.MAX_VALUE; // 最终的结果
        int sum = 0; // 子数组之和
        int i = 0 ; // 滑动窗口的起始位置
        int subLength = 0; // 子数组的长度

        for(int j = 0; j < nums.length ; j++){
            sum += nums[j];
            while(sum >= target){
                subLength = j - i + 1;
                result = Math.min(result,subLength);
                // 此处为滑动窗口的精髓之处，不断变更滑动窗口的起始位置
                sum -= nums[i++];
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

}

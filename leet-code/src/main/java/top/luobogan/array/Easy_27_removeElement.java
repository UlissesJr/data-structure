package top.luobogan.array;

/**
 * https://leetcode.cn/problems/remove-element/
 * 移除元素
 * Created by LuoboGan
 * Date:2023/2/8
 */

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Easy_27_removeElement {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,4,3,3};
        int search = removeElement(nums, 3);
        System.out.println(search);
    }

    /**
     * 双指针
     */
    public static int removeElement(int[] nums, int val) {

        int slow = 0 , fast = 0;

        while ( fast < nums.length ) {
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow += 1;
            }
            fast += 1;
        }

        return slow ;
    }

}

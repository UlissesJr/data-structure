package top.luobogan.array;

/**
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 * 只要数组有序，就应该想到双指针技巧。
 * Created by LuoboGan
 * Date:2023/2/28
 */
public class Medium_167_twoSumIIInputArrayIsSorted {

    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] numbers, int target) {

        // 一左一右两个指针相向而行
        int left = 0 , right = numbers.length -1;

        while(left < right){
            int sum = numbers[left] + numbers[right];

            if(sum == target){
                return new int[]{left+1,right+1};
            }else if(sum < target){
                left += 1;
            }else{
                right -= 1;
            }
        }

        return new int[]{-1, -1};

    }

}

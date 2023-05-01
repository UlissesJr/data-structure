package top.luobogan.array;

/**
 * https://leetcode.cn/problems/move-zeroes/
 * 其实就相当于移除 nums 中的所有 0，然后再把后面的元素都赋值为 0 即可。
 * Created by LuoboGan
 * Date:2023/2/28
 */
public class Easy_283_moveZeroes {

    public static void main(String[] args) {

    }

    public static void moveZeroes(int[] nums) {

        if(nums.length < 1){
            return ;
        }

        int slow = 0;
        int fast = 0;

        while( fast < nums.length ){
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }

        for(; slow < nums.length ; slow ++){
            nums[slow] = 0;
        }
    }

}

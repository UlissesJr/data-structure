package top.luobogan.array;

/**
 * 二分查找
 * https://leetcode.cn/problems/binary-search/
 * Created by LuoboGan
 * Date:2023/2/8
 */

public class Code_704_binarySearch {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int search = search(nums, 2);
        System.out.println(search);
    }


    public static int search(int[] nums, int target) {

        int low = 0 ;
        int high = nums.length -1 ;
        
        while (low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] < target){
                low = mid +1  ;
            }else if (nums[mid] > target){
                high = mid - 1 ;
            }else {
                return mid;
            }
        }

        return -1;

    }

}

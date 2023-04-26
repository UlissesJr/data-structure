package top.luobogan.array;

/**
 * Created by LuoboGan
 * Date:2023/2/24
 */
public class Code_26_removeDuplicatesFromSortedArray {

    public static void main(String[] args) {


    }


    public int removeDuplicates(int[] nums) {

        if ( nums.length == 0 ) {
            return 0;
        }

        int slow = 0 , fast = 0 ;

        // 快指针从头遍历到尾，如果遇到不相同的就同步到慢指针
        while( fast < nums.length ){
            if(nums[slow] != nums[fast]){
                nums[++slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;

    }

}

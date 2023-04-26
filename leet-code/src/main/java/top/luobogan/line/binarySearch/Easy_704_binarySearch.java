package top.luobogan.line.binarySearch;

/**
 * https://leetcode.cn/problems/binary-search/
 * Created by LuoboGan
 * Date:2023/3/5
 */
public class Easy_704_binarySearch {

    public static void main(String[] args) {

    }

    int binary_search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;  // 注意 左闭右闭
        while(left <= right) {  // 这里 left == right 的时候，区间里还有一个值，所以依然需要进行判断
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] == target) {
                // 直接返回
                return mid;
            }
        }
        // 直接返回
        return -1;
    }

    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }

        // 因为是最左匹配，所以右边界比较安全，如果target比所有数都小或者为nums[0]，则只有right会移动，left最后保持在0的位置
        // 如果target比所有数都大，则 left = mid + 1 ，则有越界的可能性
        if (left == nums.length) {
            return -1;
        }
        // 以为 nums[mid] == target 时移动的是right，所以left没问题
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }

    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }

        // 因为是最右匹配，所以左边界比较安全，如果target比所有数都小或者为nums[0]，则只有right会移动，left最后保持在0的位置
        // 如果target比所有数都大，则 left 会等于 nums.length
        // 如果left为0，说明没有匹配的数据
        if (left - 1 < 0) {
            return -1;
        }
        // 因为 nums[mid] == target 时移动的left，所以比较的时候 left 需要 -1
        // 判断一下 nums[left] 是不是 target
        return nums[left - 1] == target ? (left - 1) : -1;
    }

}

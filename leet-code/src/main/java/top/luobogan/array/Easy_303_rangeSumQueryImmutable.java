package top.luobogan.array;

/**
 * https://leetcode.cn/problems/range-sum-query-immutable/
 * Created by LuoboGan
 * Date:2023/2/28
 */
public class Easy_303_rangeSumQueryImmutable {

    private int[] preSum;

    /* 输入一个数组，构造前缀和 */
    public void NumArray(int[] nums) {
        preSum = new int[nums.length+1];
        for( int i = 1; i < preSum.length; i++ ){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
    }

    /* 查询闭区间 [left, right] 的累加和 */
    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }

}

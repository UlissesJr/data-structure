package top.luobogan.array;

/**
 * Created by LuoboGan
 * Date:2023/3/4
 */
public class Medium_370_rangeAddition {

    private int[] diff;

    public Medium_370_rangeAddition(int[] nums) {
        assert nums.length > 0;
        diff = new int[nums.length];
        diff[0] = nums[0];
        for(int i = 1 ; i < nums.length; i++){
            diff[i] = nums[i] - nums[i-1];
        }
    }

    public void increment(int startIndex, int endIndex , int val){
        diff[startIndex] += val;
        if(endIndex + 1 < diff.length){
            diff[endIndex + 1] -= val;
        }
    }

    public int[] result(){
        int[] result = new int[diff.length];
        result[0] = diff[0];
        for( int i = 0 ; i < diff.length; i++ ){
            result[i] = result[i-1] + diff[i];
        }

        return result;
    }

    public int[] getModifiedArray(int length, int[][] updates) {

        // 初始化数组
        int[] initNums = new int[length];
        Medium_370_rangeAddition rangeAddition = new Medium_370_rangeAddition(initNums);

        for(int i = 0 ; i < updates.length ; i++){
            increment(updates[i][0],updates[i][1],updates[i][2]);
        }

        return rangeAddition.result();
    }



}

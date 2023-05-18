package top.luobogan.fresh.binary;

import top.luobogan.fresh.sort.InsertSort;

/**
 * Created by LuoboGan
 * 二分查找 : 求局部最小值 只需找出一个满足条件的最小值就可以 (只要确定有一侧肯定有目标值，就可以采用二分法，不必非要是有序数组)
 * arr[0] < arr[1] 则局部最小值为 arr[0]
 * arr[N-2] > arr[N-1] 则局部最小值为 arr[N-1]
 * arr[i-1] > arr[i] < arr[i+1] 则局部最小值为 arr[i]
 */
public class BSAwesome {

    public static void main(String[] args) {

        int maxLen = 1000;
        int maxValue = 100;
        int testTime = 1000000000;
        boolean succeed = true;
        for( int i = 0; i< testTime; i++ ){
            int[] arr = randomArray(maxLen,maxValue);
//            int[] arr = {3,2,3,4,3,2,3};
            int ans = oneMinIndex(arr);
            boolean check = check(arr, ans);
            if(!check){
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    /**
     * arr 整体无序，且相邻的数不相等
     */
    public static int oneMinIndex(int[] arr){

        if(arr == null || arr.length ==0){
            return -1;
        }
        int n = arr.length;
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return arr[0] < arr[1] ? 0 : 1 ;
        }

        // 下面都是包含三个数及以上的情况
        if(arr[n-1] < arr[n-2]){
            return n-1;
        }

        // 左闭右闭区间
        int L = 0;
        int R = n - 1;
        int mid = -1;

        while(L < R - 1){ // 保证有三个数才进行二分查找，防止数组越界，比如mid为0的情况
            mid = L + ((R-L) >> 1);
            if(arr[mid-1] < arr[mid]){
                R = mid-1;
            }else if(arr[mid+1] < arr[mid]){
                L = mid + 1;
            }else{
                return mid;
            }
        }
        return arr[L] < arr[R] ? L : R;
    }

    // 生成随机数组，且相邻数不相等
    public static int[] randomArray(int maxLen, int maxValue){
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if(len > 0){
            arr[0] = (int) (Math.random() * maxValue);
            for(int i = 1; i < len ; i++ ){
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                }while(arr[i] == arr[i-1]);
            }
        }
        return arr;
    }

    //检查结果是否正确
    public static boolean check(int[] arr,int index){
        if(arr.length == 0){
            return index == -1;
        }

        int left = index - 1;
        int right = index + 1;
        boolean leftBigger = left < 0 || arr[left] > arr[index];
        boolean rightBigger = right >= arr.length || arr[right] > arr[index];
        return leftBigger && rightBigger;

    }

    public static void printArray(int[] arr){
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }

}

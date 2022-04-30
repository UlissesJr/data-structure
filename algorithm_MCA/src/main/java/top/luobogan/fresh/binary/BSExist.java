package top.luobogan.fresh.binary;

import top.luobogan.fresh.sort.InsertSort;

/**
 * Created by LuoboGan
 * 二分查找有序数组中的num
 * Date:2021/12/13
 */
public class BSExist {

    public static void main(String[] args) {

        int maxLen = 500;
        int maxValue = 1000;
        int testTime = 10000;
        boolean succeed = true;
        for( int i = 0; i< testTime; i++ ){
            int value = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
            System.out.println(value);
            int[] arr = lenRandomValueRandom(maxLen,maxValue);
            if(test(arr,value) != find(arr,value)){
                succeed = false;
                break;
            }
            System.out.println(find(arr,value));
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    //arr保证有序
    public static boolean find(int[]arr, int num) {

        if( arr == null || arr.length == 0){
            return false;
        }

        int L = 0;
        int R = arr.length -1 ;
        int M = 0 ;

        while(L <= R){
            M = L + ((R-L) >> 1);
            if( arr[M] < num ){
                L = M + 1;
            }else if(arr[M] > num){
                R = M - 1;
            }else{
                return true;
            }
        }
        // 没找到
        return false;
    }

    public static boolean test(int[] sorted, int num ){
        for(int cur : sorted){
            if(cur == num){
                return true;
            }
        }
        return false;
    }


    public static int[] lenRandomValueRandom(int maxLen, int maxValue){
        int len = (int) (Math.random() * maxLen);
        if(len < 1){
            len = 1;
        }
        int[] ans = new int[len];
        for(int i = 0; i < len ; i++){
            ans[i] = (int)(Math.random() * maxValue);
        }
        return InsertSort.sort(ans);
    }

}

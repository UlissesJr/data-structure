package top.luobogan.fresh.binary;

import top.luobogan.fresh.sort.InsertSort;

/**
 * Created by LuoboGan
 * 二分查找 :在有序数组中找到 <=num 最右的位置
 * Date:2021/12/13
 */
public class BSNearRight {

    public static void main(String[] args) {

        int maxLen = 10;
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


    // arr保证有序
    public static int find(int[]arr, int num) {

        if( arr == null || arr.length == 0){
            return -1;
        }

        int L = 0;
        int R = arr.length -1 ;
        int M = 0 ;
        int index = -1;

        while(L <= R){
            M = L + ((R-L) >> 1);
           if(arr[M] <= num){
               L = M + 1;
               index = M;
           }else{
               R = M - 1;
           }
        }

        return index;
    }

    public static int test(int[] arr, int value){
        int index = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= value){
                index = i ;
            }else {
                return index ;
            }
        }
        return index;
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

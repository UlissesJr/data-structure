package top.luobogan.fresh.sort;

/**
 * Created by LuoboGan
 * Date:2021/12/6
 */
public class Compare {

    public static int[] lenRandomValueRandom(int maxLen, int maxValue){
        int len = (int) (Math.random() * maxLen);
        if(len < 1){
            len = 1;
        }
        int[] ans = new int[len];
        for(int i = 0; i < len ; i++){
            ans[i] = (int)(Math.random() * maxValue);
        }
        System.out.println("len : " + len );
        return ans;
    }

    public static int[] copyArray(int[] arr){
        int[] ans = new int[arr.length];
        for( int i = 0 ; i < arr.length ; i++ ){
            ans[i] = arr[i];
        }
        return ans;
    }

    public static boolean isSorted(int[] arr){

        if(arr == null){
            return true;
        }

        if( arr.length < 2 ){
            System.out.println(arr[0] + "");
            return true;
        }
        int max = arr[0];
        for( int i = 0 ; i < arr.length ; i++ ){
            if(max > arr[i]){
                return false;
            }
            max = Math.max(max,arr[i]);
        }
        return true;

    }

    public static void main(String[] args) {
        int maxLen = 50;
        int maxValue = 1000;
        int testTime = 10000;
        for( int i = 0; i< testTime; i++ ){
            int[] arr1 = lenRandomValueRandom(maxLen,maxValue);
            int[] arr2 = copyArray(arr1);
            arr1 = BubbleSort.sort(arr1);
            arr2 = SelectSort.sort(arr2);
            if(!isSorted(arr1)){
                System.out.println("BubbleSort Error.");
            }
            if(!isSorted(arr2)){
                System.out.println("SelectSort Error.");
            }
        }
    }


}

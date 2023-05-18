package top.luobogan.JVM;

import java.math.BigDecimal;
import java.util.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        long[][] arrs = resolveInput();
        getOutputResult(arrs);

    }

    /**
     * 处理输入
     */
    private static long[][] resolveInput(){

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long[][] arrs = new long[t][2];
        for( int i = 0; i < t ; i++ ){
            arrs[i][0] = scanner.nextLong();
            arrs[i][1] = scanner.nextLong();
        }

        return arrs;
    }

    /**
     * 输出结果
     */
    private static void getOutputResult(long[][] arrs){
        for(long[] arr : arrs){
            String nkResult = getNKResult(arr[0], arr[1]);
            System.out.println(nkResult);
        }
    }

    /**
     * 获取指定 n k 节点的值；
     */
    private static String getNKResult (long n , long k){

        if( n == 1 ){
            return "red";
        }

        if( n == 2 ){
            if(k == 0){
                return "blue";
            }else{
                return "red";
            }
        }

        long mid = 1L << (n-2);

        if(k >= mid){
            return getNKResult(n-1,k-mid);
        }else{
            if("red".equals(getNKResult(n-1,k))){
                return "blue";
            }else{
                return "red";
            }
        }
    }
}

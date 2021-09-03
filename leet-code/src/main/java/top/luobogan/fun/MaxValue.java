package top.luobogan.fun;

import com.sun.org.apache.xpath.internal.operations.Minus;

import java.util.*;

/**
 * Created by LuoboGan
 * 给定一个二元组（x1,y1）...(xn,yn), 已经按照x从小到大排好序了, 求yi+yj + |xi-xj|的最大值（i!=j）.
 * Date:2021/9/3
 * @author Luobogan
 */
public class MaxValue {

    static int[][] array = {{1,5},{2,1},{3,7},{6,1},{9,12},{10,10},{11,2},{12,7},{16,4},{17,17},{21,4},{22,12},
            {30,51},{32,22}};

    public static void main(String[] args) {

//        int simplicity = simplicity(array);
        int quick = quick(array);
        System.out.println(quick);


    }

    /**
     * 朴素算法
     * @param array
     * @return
     */
    public static int simplicity(int[][] array){

        if(array.length == 0){
            return 0;
        }

        int i = array.length;
        int j = i;
        int ans = 0;
        for(int a = 1; a < i ; a++){
            for(int b = 0; b < a ; b++){
                ans = Math.max(ans,array[a][1]+array[b][1] + array[a][0]-array[b][0]);
            }
        }
        return ans;
    }

    /**
     * 优化项：（ 假设 i > j ） 计算式子变为: yi+yj + xi-xj = xi+yi + yj-xj
     *  1. xi+yi 不随J的改变而改变, 一遍循环可以把 最大值 xi+yi 找出
     *  2. yj-xj 也可以一遍循环找出最大值, 可以与1中的循环合在一起运算
     * @param array
     * @return
     */
    public static int quick(int[][] array){

        if(array.length == 0){
            return 0;
        }
        int i = array.length;
        // 将x0+y0作为temp初始化.
        int temp = array[0][0] + array[0][1];
        int minusMax = -10000000;
        int ans = -10000;
        int tempIndex = 0;
        int minusMaxIndex = 0;
        Set maxV = new HashSet();
        List maxList = new ArrayList();
        for (int a = 1; a < i; a++) {
            // 求xi+yi最大值
            int xxxtemp = temp;
            int xxxminuxMax = minusMax;
            temp = Math.max(temp,array[a][0] + array[a][1]);
            if(xxxtemp != temp){
                tempIndex = a;
            }
            minusMax = Math.max(minusMax,array[a-1][1]-array[a-1][0]);
            if(xxxminuxMax != minusMax){
                minusMaxIndex = a-1;
            }
            ans = temp + minusMax;
            maxV.add(ans);
        }
        // 对set进行排序
        Set<Integer> sortSet = new TreeSet<Integer>((o1,o2) -> o2.compareTo(o1));
        sortSet.addAll(maxV);
        for(int element:sortSet){
            maxList.add(element);
        }
        Object[] objects = sortSet.toArray();
        if(maxList.size() <= 1){
            return (int) maxList.get(0);
        }
        Integer max = 0;
        if(tempIndex != minusMaxIndex){
            max = (Integer) maxList.get(0);
        }
            max = (Integer)maxList.get(1);
        System.out.println(maxList.toString());
        System.out.println("temp: " + temp + ",minus: " + minusMax);
        return max;
    }

}

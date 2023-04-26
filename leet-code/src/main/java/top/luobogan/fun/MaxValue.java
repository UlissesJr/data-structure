package top.luobogan.fun;

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

//        int ans = simplicity(array);
        int ans = quick(array);
        System.out.println(ans);


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
        int temp = -100000;
        int ans = -100000;
        for (int a = 1; a < i; a++) {
            // 求xi+yi最大值
            temp = Math.max(temp,array[a-1][1] - array[a-1][0]);
            ans = Math.max(ans,array[a][1] + array[a][0] + temp);
        }

        return ans;
    }

}

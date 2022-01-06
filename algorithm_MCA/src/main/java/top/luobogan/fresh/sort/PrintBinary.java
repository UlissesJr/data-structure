package top.luobogan.fresh.sort;

/**
 * Created by LuoboGan
 * 打印某个数的二进制
 * Date:2021/11/12
 */
public class PrintBinary {

    public static void print(int num){

        for(int i =31; i >= 0; i--){
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int num = 2231;
        print(num);
        // 00000000000000000000100010110111
        print(num<<20);
        // 10001011011100000000000000000000
        print(num<<21);
        // 00010110111000000000000000000000
        print(-1);
        print(~1+1);
        print(Integer.MIN_VALUE);

        System.out.println(-1);
        System.out.println(~1);
        print(-2);
        // ~a+1 = -a (a不论正负都适用)
        System.out.println(~(-1)+1);

    }

}

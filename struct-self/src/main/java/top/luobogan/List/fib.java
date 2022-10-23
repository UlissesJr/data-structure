package top.luobogan.List;

import top.luobogan.Utils.Times;

/**
 * Created by LuoboGan
 * Date:2022-10-05
 */
public class fib {

    public static void main(String[] args) {
        Times.check("fibCal", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fibCal(45));
            }
        });
        Times.check("fib2", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib2(45));
            }
        });
    }

    public static Integer fibCal(int num){
        if(num <= 1){
            return num;
        }
        return fibCal(num-1) + fibCal(num-2);
    }

    public static Integer fib2(int num){
        if(num <= 1){
            return num;
        }

        int first = 0;
        int second = 1;
        for(int i = 0; i < num - 1; i++){
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }
}

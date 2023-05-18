package top.luobogan.JVM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by LuoboGan
 * Date:2023/3/27
 */
public class Demo {

    public static void main(String[] args) throws ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int x = scanner.nextInt();

        System.out.println(getResult(m,n,x));
    }

    public static int getResult(int sheep, int wolf, int boat){
        ArrayList<Integer> result = new ArrayList<>();
        deepFirstSearch(sheep,wolf,boat,0,0,0,result);

        if( result.size() > 0 ){
            return Collections.min(result);
        }else {
            return 0;
        }
    }



    public static void deepFirstSearch(int sheep,int wolf,int boat,int o_sheep , int o_wolf, int count,ArrayList<Integer> result){

        // 边界处理
        if(sheep == 0 && wolf == 0){
            result.add(count);
            return;
        }

        if(sheep + wolf <= boat){
            result.add(count + 1);
            return;
        }

        for( int i = 0; i <= Math.min(boat,sheep); i++ ){
            for( int j = 0 ; j <= Math.min(boat,wolf); j++ ){
                if(i + j == 0){
                    continue;
                }
                if(i + j > boat){
                    break;
                }
                if((sheep -i <= wolf - j) && (sheep - i != 0)){
                    break;
                }
                if((o_sheep + i <= o_wolf + j) && (o_sheep + i != 0)){
                    break;
                }
                if( (o_sheep + i <= 0) && ( o_wolf + j >= boat ) ){
                    break;
                }

                deepFirstSearch(sheep -i , wolf -j ,boat, o_sheep + i , o_wolf + j, count + 1, result);

            }
        }
    }

}

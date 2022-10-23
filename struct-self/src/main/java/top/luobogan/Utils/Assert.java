package top.luobogan.Utils;

/**
 * Created by LuoboGan
 * Date:2022/10/13
 */
public class Assert {

    public static void check(boolean value){
        try{
            if(!value) {
                throw new Exception("测试未通过");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

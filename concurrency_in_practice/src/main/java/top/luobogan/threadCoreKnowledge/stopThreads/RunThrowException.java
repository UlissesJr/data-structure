package top.luobogan.threadCoreKnowledge.stopThreads;

/**
 * run无法抛出checked Exception，只能用try/catch
 * 重写方法一定不能抛出新的检査异常或者比被重写方法声明更加宽泛的检査型异常。
 * 访问修饰符必须大于或者等于被重写的方法
 * Created by LuoboGan
 * Date:2022-09-18
 */
public class RunThrowException {

    public void aVoid() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run()  {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

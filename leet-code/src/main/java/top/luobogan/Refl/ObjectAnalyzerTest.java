package top.luobogan.Refl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LuoboGan
 * Date:2022/12/1
 */
public class ObjectAnalyzerTest
{
    public static void main(String[] args)
            throws ReflectiveOperationException
    {
        List<Integer> squares = new ArrayList<Integer>();
        for (int i = 1; i <= 5; i++) {
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
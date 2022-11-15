package top.luobogan;

import top.luobogan.List.LinkedList;
import top.luobogan.List.List;



/**
 * Created by LuoboGan
 * Date:2022-10-12
 */
public class MainClass {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(20);
        list.add(0,10);
        list.add(30);
        list.add(list.size(),40);
        list.remove(1);
        System.out.println(list);
     }
}

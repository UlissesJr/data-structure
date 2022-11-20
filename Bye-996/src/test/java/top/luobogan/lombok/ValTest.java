package top.luobogan.lombok;

import lombok.val;

import java.util.ArrayList;

/**
 * @val注解
 * 弱语言变量
 */
public class ValTest {

    private static Object[] elementData;

    public static void main(String[] args) {
        ValTest();
    }

    public static void ValTest() {
        val field = "zhangxiaoxi";

        int length = elementData.length;

        val list = new ArrayList<String>();
        list.add("zhangxiaoxi");
    }

}

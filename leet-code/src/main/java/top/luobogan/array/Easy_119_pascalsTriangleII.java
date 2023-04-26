package top.luobogan.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/pascals-triangle-ii/
 * Created by LuoboGan
 * Date:2023/3/13
 */
public class Easy_119_pascalsTriangleII {

    public static void main(String[] args) {

    }

    public List<Integer> getRow(int rowIndex) {

        List<Integer> curRow = new ArrayList<>();
        // 每一行的开头是1
        curRow.add(1);

        if(rowIndex == 0){
            return curRow;
        }

        List<Integer> preRow = getRow(rowIndex - 1);

        for( int i = 0 ; i < preRow.size() -1 ; i++ ){
            // 每一行元素等于上一行的两个相邻元素之和
            curRow.add(preRow.get(i) + preRow.get(i+1));
        }

        // 每一行的末尾元素为1
        curRow.add(1);

        return curRow;
    }

}

package top.luobogan.tree;

/**
 * Created by LuoboGan
 * Date:2023/3/12
 */
public class Easy_ALLProbablyBinaryNumber {

    // 记录遍历过的路径
    static StringBuilder path = new StringBuilder();

    static void generateBinaryNumber(int n){
        if(n == 0){
            // 到达叶子节点
            System.out.println(path.toString());
            return ;
        }

        for (int i = 0; i <2 ; i++) {
            // 前序位置，进入节点
            path.append(i);
            // 递归子节点
            generateBinaryNumber(n - 1);
            // 后序位置，离开节点
            path.deleteCharAt(path.length() -1);
        }

    }

    public static void main(String[] args) {
        generateBinaryNumber(3);
    }

}

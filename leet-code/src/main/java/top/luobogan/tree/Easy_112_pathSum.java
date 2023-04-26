package top.luobogan.tree;

import jdk.nashorn.internal.runtime.regexp.joni.constants.Traverse;

/**
 * https://leetcode.cn/problems/path-sum/
 * Created by LuoboGan
 * Date:2023/3/11
 */
public class Easy_112_pathSum {

    public static void main(String[] args) {

    }

    boolean hasPathSum = false;

    int pathSum = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        traverse(root,targetSum);
        return hasPathSum;

    }

    public void traverse(TreeNode root, int targetSum){

        if(root == null){
            return ;
        }

        // 前序遍历加入数字
        pathSum += root.val;
        // 到达根节点的时候计算是否满足需求
        if(root.left == null && root.right == null){
            if(targetSum == pathSum){
                hasPathSum = true;
            }
        }
        traverse(root.left,targetSum);
        traverse(root.right,targetSum);
        // 后续遍历减去数字
        pathSum -= root.val;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}

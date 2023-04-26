package top.luobogan.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/
 * Created by LuoboGan
 * Date:2023/3/14
 */
public class Medium_1161_maximumLevelSumOfABinaryTree {

    public static void main(String[] args) {

    }

    int maxLevelSum = Integer.MIN_VALUE;
    int maxLevel = 0;

    int depth = 0;

    public int maxLevelSum(TreeNode root) {
        levelOrder(root);
        return maxLevel;
    }

    public void levelOrder(TreeNode root){
        if(root == null){
            return ;
        }

        Queue<TreeNode> level = new LinkedList<>();
        level.offer(root);
        depth ++;

        while(!level.isEmpty()){
            int levelSum = 0;
            int sz = level.size();
            for( int i = 0 ; i < sz ; i++ ){
                TreeNode curNode = level.peek();
                levelSum =  levelSum + curNode.val;

                if(curNode.left != null){
                    level.offer(curNode.left);
                }
                if(curNode.right != null){
                    level.offer(curNode.right);
                }

                level.poll();
            }
            if(maxLevelSum < levelSum){
                maxLevelSum = levelSum;
                maxLevel = depth;
            }
            depth++;
        }

    }

    public class TreeNode {
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

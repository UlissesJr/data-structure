package top.luobogan.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 * Created by LuoboGan
 * Date:2023/3/6
 */
public class Easy_144_binaryTreePreorderTraversal {

    public List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {

    }


    public List<Integer> preorderTraversal(TreeNode root) {

        traverse(root);
        return res;

    }

    public void traverse(TreeNode root){

        if(root == null){
            return ;
        }

        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    // 采用递归的思想
    public List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> curRow = new ArrayList<>();

        if(root == null){
            return curRow;
        }

        // 加入根
        curRow.add(root.val);

        // 加入左子树的前序遍历
        List<Integer> leftRes = preorderTraversal2(root.left);
        // 加入右子树的前序遍历
        List<Integer> rightRes = preorderTraversal2(root.right);

        curRow.addAll(leftRes);
        curRow.addAll(rightRes);
        return curRow;
    }

    public static class TreeNode {
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

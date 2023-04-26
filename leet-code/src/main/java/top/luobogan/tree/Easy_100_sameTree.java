package top.luobogan.tree;

/**
 * https://leetcode.cn/problems/same-tree/
 * Created by LuoboGan
 * Date:2023/3/13
 */
public class Easy_100_sameTree {

    public static void main(String[] args) {

    }

    // 定义： 判断以 p 和 q 为根的两棵二叉树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        // 递归判断 p 和 q 的左右子树是否完全相同
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
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

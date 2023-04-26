package top.luobogan.tree;

/**
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 * Created by LuoboGan
 * Date:2023/3/6
 */
public class Medium_114_flattenBinaryTreeToLinkedList {

    public static void main(String[] args) {

    }

    // 定义：将以 root 为根的树拉平为链表
    void flatten(TreeNode root) {

        if(root == null){
            return ;
        }

        // 将左子树拉伸为链表
        flatten(root.left);
        TreeNode leftTree = root.left;
        // 将右子树拉伸为链表
        flatten(root.right);
        TreeNode rightTree = root.right;
        // 对左右子树进行拼接
        root.left = null;
        root.right = leftTree;

        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }

        p.right = rightTree;
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

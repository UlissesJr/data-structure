package top.luobogan.tree;

/**
 * https://leetcode.cn/problems/invert-binary-tree/
 * Created by LuoboGan
 * Date:2022/12/20
 */
public class Code_226_InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null ){
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
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



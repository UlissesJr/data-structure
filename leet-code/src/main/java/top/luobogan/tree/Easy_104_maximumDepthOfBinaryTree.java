package top.luobogan.tree;

/**
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * Created by LuoboGan
 * Date:2023/3/6
 */
public class Easy_104_maximumDepthOfBinaryTree {

    // 记录最大深度
    int res = 0;
    // 记录遍历到的节点的深度
    int depth = 0;

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        travers(root);
        return res;
    }

    public void travers(TreeNode root){

        if (root == null) {
            return;
        }

        // 前序位置
        depth++;
        if (root.left == null && root.right == null) {
            // 到达叶子节点，更新最大深度
            res = Math.max(res, depth);
        }
        travers(root.left);
        travers(root.right);
        // 后序位置
        depth--;
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

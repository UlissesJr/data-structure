package top.luobogan.tree;

/**
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 * Created by LuoboGan
 * Date:2023/3/11
 */
public class Easy_111_minimumDepthOfBinaryTree {

    public static void main(String[] args) {

    }

    int minDepth = Integer.MAX_VALUE;
    int depth = 0;

    public int minDepth(TreeNode root) {
        traverse(root);
        return minDepth;
    }

    public void traverse(TreeNode root){

        if(root == null){
            return ;
        }

        // 前序遍历加入数字
        // 到达根节点的时候计算是否满足需求
        depth ++ ;
        traverse(root.left);
        traverse(root.right);
        // 后序遍历减去数字
        // 叶子节点计算
        if(root.left == null && root.right == null){
            minDepth = Math.min(minDepth,depth);
        }
        depth--;
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

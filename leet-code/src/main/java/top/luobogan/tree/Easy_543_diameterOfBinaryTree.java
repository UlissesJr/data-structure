package top.luobogan.tree;

/**
 * Created by LuoboGan
 * Date:2023/3/6
 */
public class Easy_543_diameterOfBinaryTree {

    public int maxDiameter = 0;

    public static void main(String[] args) {

    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    public int maxDepth(TreeNode root){

        if(root == null){
            return 0;
        }

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        int myDiameter = leftMax + rightMax ;
        maxDiameter = Math.max(myDiameter,maxDiameter);

        return 1 +  Math.max(leftMax,rightMax);
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

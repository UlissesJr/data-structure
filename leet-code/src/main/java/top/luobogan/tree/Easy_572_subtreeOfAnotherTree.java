package top.luobogan.tree;

/**
 * https://leetcode.cn/problems/subtree-of-another-tree
 * Created by LuoboGan
 * Date:2023/3/13
 */
public class Easy_572_subtreeOfAnotherTree {

    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 都为null 则xiangtong
        if(root == null ){
            return subRoot == null;
        }

        // 判断当前节点是否一样
        if(isSameTree(root,subRoot)){
            return true;
        }

        // 判断左右子树是否存在一样的结构
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);

    }

    public boolean isSameTree( TreeNode p, TreeNode q ){
        if(p == null && q == null){
            return true;
        }

        if( p == null || q == null){
            return false;
        }

        if(p.val != q.val){
            return false;
        }
        // 判断其他节点是否相同
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

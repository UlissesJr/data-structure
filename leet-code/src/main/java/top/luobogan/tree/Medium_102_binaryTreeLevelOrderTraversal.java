package top.luobogan.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 * Created by LuoboGan
 * Date:2023/3/13
 */
public class Medium_102_binaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int sz = q.size();

            List<Integer> level = new LinkedList<>();
            for(int i = 0 ; i < sz ;  i++){
                TreeNode cur = q.poll();
                level.add(cur.val);
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if( cur.right != null ){
                    q.offer(cur.right);
                }
            }
            res.add(level);
        }

        return res;
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

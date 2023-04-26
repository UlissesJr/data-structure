package top.luobogan.tree;

import java.util.Stack;

/**
 * Created by LuoboGan
 * Date:2023/3/13
 */
public class RecursivelyChangeIterations {

    // 模拟函数调用栈
    private Stack<TreeNode> stk = new Stack<TreeNode>();

    // 左侧树枝一撸到底
    private void pushLeftBranch(TreeNode p){
        while( p != null ){
            /* 前序遍历代码位置 */
            stk.push(p);
            p = p.left;
        }
    }

    public void traverse(TreeNode root){
        // 指向上一次遍历完的子树根节点 (最近一次被POP出去的元素)
        TreeNode visited = new TreeNode(-1);
        // 开始遍历整棵树
        pushLeftBranch(root);

        while(!stk.isEmpty()){
            TreeNode p = stk.peek();

            // p的左子树被遍历完，且右子树没有被遍历过
            if((p.left == null || p.left == visited) && p.right != visited){
                /* 中序遍历代码位置 */
                // 去遍历 p 的右子树
                pushLeftBranch(p.right);
            }

            // p的右子树被遍历完了
            if(p.right == null || p.right == visited){
                /* 后序遍历代码位置 */
                // 以 p 为根的子树被遍历完了，出栈，visited指针指向 p
                visited = stk.pop();
            }

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

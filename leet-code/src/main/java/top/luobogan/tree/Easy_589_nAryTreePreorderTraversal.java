package top.luobogan.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.cn/problems/n-ary-tree-preorder-traversal/
 * Created by LuoboGan
 * Date:2023/3/12
 */
public class Easy_589_nAryTreePreorderTraversal {

    public static void main(String[] args) {

    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        traverse(root);
        return  res;
    }

    public void traverse(Node root){

        if(root == null){
            return ;
        }

        // 前序遍历
        res.add(root.val);

        for (Node child : root.children) {
            traverse(child);
        }
        // 后序遍历
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


}

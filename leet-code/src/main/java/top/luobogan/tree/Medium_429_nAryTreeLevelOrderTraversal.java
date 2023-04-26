package top.luobogan.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/n-ary-tree-level-order-traversal/
 * Created by LuoboGan
 * Date:2023/3/14
 */
public class Medium_429_nAryTreeLevelOrderTraversal {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();

        if(root == null){
            return res;
        }

        queue.offer(root);

        while(!queue.isEmpty()){
            int sz = queue.size();
            List<Integer> levelRes = new ArrayList<>();
            for( int i = 0 ; i < sz; i++ ){
                Node curNode = queue.peek();
                levelRes.add(curNode.val);

                for (Node child : curNode.children) {
                    queue.offer(child);
                }

                queue.poll();
            }
            res.add(levelRes);
        }
        return res;
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

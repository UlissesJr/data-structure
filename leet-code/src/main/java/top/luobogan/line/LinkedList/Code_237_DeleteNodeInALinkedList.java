package top.luobogan.line.LinkedList;

/**
 * https://leetcode.cn/problems/delete-node-in-a-linked-list/
 * Created by LuoboGan
 * Date:2022/11/15
 */
public class Code_237_DeleteNodeInALinkedList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }


}

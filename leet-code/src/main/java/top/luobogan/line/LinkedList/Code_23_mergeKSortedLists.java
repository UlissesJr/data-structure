package top.luobogan.line.LinkedList;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 * Created by LuoboGan
 * Date:2023/2/22
 */
public class Code_23_mergeKSortedLists {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1,new ListNode(3,new ListNode(5,new ListNode(7))));
        ListNode listNode2 = new ListNode(2,new ListNode(4,new ListNode(6,new ListNode(8))));
        ListNode[] lists = new ListNode[]{listNode1,listNode2};
        mergeKLists(lists);
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b)->(a.val - b.val));
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

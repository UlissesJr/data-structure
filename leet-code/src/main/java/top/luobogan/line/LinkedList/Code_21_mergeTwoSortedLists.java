package top.luobogan.line.LinkedList;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 * Created by LuoboGan
 * Date:2023/2/21
 */
public class Code_21_mergeTwoSortedLists {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(7)));
        ListNode l2 = new ListNode(1,new ListNode(5,new ListNode(6,new ListNode(8))));

        ListNode listNode = mergeTwoLists(l1, l2);

    }

    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = l1, p2 = l2;

        while (p1 != null && p2 != null) {
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p 指针不断前进
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
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
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

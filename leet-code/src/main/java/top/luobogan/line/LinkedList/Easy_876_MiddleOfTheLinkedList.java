package top.luobogan.line.LinkedList;

/**
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 * Created by LuoboGan
 * Date:2022/11/16
 * 给定链表的结点数介于 1 和 100 之间。
 */
public class Easy_876_MiddleOfTheLinkedList {

    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {

        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public class ListNode {
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

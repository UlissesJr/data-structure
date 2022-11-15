package top.luobogan.LinkedList;

/**
 * https://leetcode.cn/problems/reverse-linked-list/
 * Ctrl+Alt+L 代码格式化快捷键
 * Created by LuoboGan
 * Date:2022/11/15
 */
public class Code_206_ReverseLinkedList {

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


    /**
     * 递归的解法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }




}

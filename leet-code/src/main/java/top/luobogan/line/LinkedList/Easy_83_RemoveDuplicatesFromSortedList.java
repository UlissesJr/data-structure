package top.luobogan.line.LinkedList;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * Created by LuoboGan
 * Date:2022/11/16
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class Easy_83_RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1,new ListNode(1,new ListNode(2,null)));
        deleteDuplicates(head);

    }

    public static ListNode deleteDuplicates(ListNode head) {

        // 虚拟头节点
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        // 快慢指针
        ListNode slow = dummy;
        ListNode fast = dummy;

        while( fast != null ){
            if(slow.val != fast.val){
                ListNode tmp = slow;
                slow = fast;
                tmp.next = fast;
            }

            fast = fast.next;
        }

        // 对最后一个节点做特殊处理
        slow.next = null;

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

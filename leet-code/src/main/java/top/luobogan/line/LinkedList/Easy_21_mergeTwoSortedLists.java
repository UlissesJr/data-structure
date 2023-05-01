package top.luobogan.line.LinkedList;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 * Created by LuoboGan
 * Date:2023/2/21
 */
public class Easy_21_mergeTwoSortedLists {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(7)));
        ListNode l2 = new ListNode(1,new ListNode(5,new ListNode(6,new ListNode(8))));

        ListNode listNode = mergeTwoLists(l1, l2);

    }

    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟头节点
        ListNode dummy = new ListNode(-1,null);
        ListNode p1 = l1, p2 = l2;

        ListNode p = dummy;
        while(p1 != null && p2 != null){

            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            }else{
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }

        if( p1 != null ){
            p.next = p1;
        }

        if( p2 != null ){
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

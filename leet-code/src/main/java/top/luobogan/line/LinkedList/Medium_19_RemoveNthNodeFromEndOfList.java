package top.luobogan.line.LinkedList;

/**
 *
 * 删除链表的倒数第N个节点
 */
public class Medium_19_RemoveNthNodeFromEndOfList {


    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 定位为到第N+1个节点
        ListNode x = findFromEnd(dummy, n+1);

        // 删掉倒数第 n 个节点
        x.next = x.next.next;

        return dummy.next;
    }

    private ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;

        for(int i = 0; i < k ; i++ ){
            p1 = p1.next;
        }

        ListNode p2 = head;
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
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

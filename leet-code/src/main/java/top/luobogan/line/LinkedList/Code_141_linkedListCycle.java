package top.luobogan.line.LinkedList;

/**
 * https://leetcode.cn/problems/linked-list-cycle/
 * Created by LuoboGan
 * Date:2022/11/16
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 */
public class Code_141_linkedListCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public boolean hasCycle(ListNode head) {

        if(head == null || head.next == null){
            return false;
        }

        // 到这里保证有两个节点
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }


}

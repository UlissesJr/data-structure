package top.luobogan.line.LinkedList;

/**
 * https://leetcode.cn/problems/c32eOV/
 * Created by LuoboGan
 * Date:2023/2/23
 */
public class JZ2_22_TheEntryNodeOfALinkedListRing {

    public static void main(String[] args) {

    }

    public static ListNode detectCycle(ListNode head) {

        // 定义快慢指针
        ListNode slow = head;
        ListNode fast = head;

        // 先找到相遇点
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                break;
            }
        }

        if (fast == null || fast.next == null) {
            // fast 遇到空指针说明没有环
            return null;
        }

        // 将slow定位到头指针 与 fast同速走，再次相遇就是环的起点
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
            if(slow == fast){
                break;
            }
        }

        return slow;

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

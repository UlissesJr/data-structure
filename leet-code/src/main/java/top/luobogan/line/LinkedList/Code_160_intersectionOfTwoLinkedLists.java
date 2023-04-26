package top.luobogan.line.LinkedList;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * Created by LuoboGan
 * Date:2023/2/24
 */
public class Code_160_intersectionOfTwoLinkedLists {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p1 = headA;
        ListNode p2 = headB;

        // 便利操作，相等则终止
        while (p1 != p2){
            if(p1 != null){
                p1 = p1.next;
            }else {
                p1 = headB;
            }

            if(p2 != null){
                p2 = p2.next;
            }else{
                p2 =headA;
            }
        }

        return p1;
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

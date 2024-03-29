package top.luobogan.line.LinkedList;

/**
 * https://leetcode.cn/problems/partition-list/
 * Created by LuoboGan
 * Date:2023/2/22
 */
public class Medium_86_partitionList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(5,new ListNode(6,new ListNode(8))));
        partition(listNode,5);
    }

    public static ListNode partition(ListNode head, int x) {
        // 存放小于 x 的链表的虚拟头结点
        ListNode dummy1 = new ListNode(-1);
        // 存放大于等于 x 的链表的虚拟头结点
        ListNode dummy2 = new ListNode(-1);
        // p1, p2 指针负责生成结果链表
        ListNode p1 = dummy1, p2 = dummy2;

        // p 负责遍历原链表，类似合并两个有序链表的逻辑
        ListNode p = head;
        // 这里是将一个链表分解成两个链表
        while(p != null){

            if(p.val < x){
                p1.next = p;
                p1 = p1.next;
            }else{
                p2.next = p;
                p2 = p2.next;
            }
            // 断开原链表中的每个节点的 next 指针
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        // 连接两个链表
        p1.next = dummy2.next;

        return dummy1.next;
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

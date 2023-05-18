package top.luobogan.line.LinkedList;

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

        // 该部分判断可以找到链表的倒数第一个不为null的节点
        if(head == null || head.next == null){
            return head;
        }

        // 到这一步链表至少存在两个节点
        // 加入此时head为倒数第二个节点，reverseList返回的newHead为倒数第一个节点
        ListNode newHead = reverseList(head.next);
        // 此时倒数第一个节点的next指向倒数第二个对象
        head.next.next = head;
        // 倒数第二个对象的next指向null对象
        head.next = null;

        // 注意这里的newHead始终没有变，一致传递带最外层
        return newHead;

    }

    /**
     * 采用迭代-头插法 实现链表反转
     * 这是一种双指针的解法
     */
    public ListNode reverseList2(ListNode head) {

        ListNode pre = null;
        ListNode next = null;
        while( head != null ){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

}

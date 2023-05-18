package top.luobogan.line.LinkedList;

/**
 * https://leetcode.cn/problems/add-two-numbers/
 * 两数相加
 */
public class Medium_2_AddTwoNumbers {

    public static void main(String[] args) {

    }

    /**
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1,null);
        int plus = 0;
        ListNode p = dummy;
        while(l1 != null || l2 != null){
            int l1Val = 0;
            int l2Val = 0;
            if(l1 != null){
                l1Val = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                l2Val = l2.val;
                l2 = l2.next;
            }
            int sum = l1Val + l2Val + plus;

            if( sum > 9 ){
                sum = sum % 10;
                plus = 1;
            }else{
                plus = 0;
            }
            p.next = new ListNode(sum,null);
            p = p.next;
        }

        if(plus == 1){
            p.next = new ListNode(1,null);
        }

        return dummy.next;

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

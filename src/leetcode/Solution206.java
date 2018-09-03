/**
 * 反转一个单链表。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
package leetcode;

public class Solution206 {
    public ListNode reverseList(ListNode head) {
        //头插法
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = null;
        ListNode p = head, q = head;
        while(p != null){
            p = q.next;
            q.next = dummyHead.next;
            dummyHead.next = q;
            q = p;
        }
        return dummyHead.next;
    }
}

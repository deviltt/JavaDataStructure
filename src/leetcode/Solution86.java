/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
package leetcode;

public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(-1);
        ListNode dummyHead2 = new ListNode(-1);
        ListNode cur1 = dummyHead1;
        ListNode cur2 = dummyHead2;

        while(head != null){
            if(head.val < x){
                cur1.next = head;
                cur1 = cur1.next;
            }
            else{
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur2.next = null;
        cur1.next = dummyHead2.next;
        return dummyHead1.next;
    }
}

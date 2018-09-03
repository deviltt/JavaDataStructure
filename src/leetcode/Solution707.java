package leetcode;

public class Solution707 {
    class ListNode{
        ListNode next;
        int val;
        ListNode(int x, ListNode next){
            this.val = x;
            this.next = next;
        }
    }
    private ListNode dummyHead;
    private int size;

    /** Initialize your data structure here. */
    public Solution707() {
        dummyHead = new ListNode(-1, null);
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size)
            return -1;
        ListNode p = dummyHead;
        for(int i = 0; i <= index; i++)
            p = p.next;
        return p.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size)
            return;
        ListNode p = dummyHead;
        ListNode indexVal = new ListNode(val, null);
        for(int i = 0; i < index; i++)
            p = p.next;
        // p.next = new ListNode(val, p.next);
        indexVal.next = p.next;
        p.next = indexVal;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size)
            return;
        ListNode p = dummyHead;
        ListNode q = dummyHead.next;
        for(int i = 0; i < index; i++){
            p = p.next;
            q = q.next;
        }
        // ListNode q = p.next;
        // p.next = q.next;
        // q.next = null;
        p.next = q.next;
        size--;
    }
}

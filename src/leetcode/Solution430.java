/**
 * 您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。
 * 这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * 输入:
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 * 输出:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 */
package leetcode;

public class Solution430 {
    public Node flatten(Node head) {
        if(head == null)
            return head;
        dfs(head);
        return head;
    }

    private Node dfs(Node head){
        Node curPre, cur, next;
        curPre = head;
        while(curPre != null){
            if(curPre.child != null){
                if(curPre.next != null){
                    next = curPre.next;
                    curPre.next = curPre.child;
                    curPre.child.prev = curPre;
                    curPre.child = null;
                    cur = dfs(curPre.next);
                    cur.next = next;
                    next.prev = cur;
                }
                else{
                    curPre.next = curPre.child;
                    curPre.child.prev = curPre;
                    curPre.child = null;
                }
            }
            if(curPre.next == null)
                break;
            else
                curPre = curPre.next;
        }
        return curPre;
    }
}
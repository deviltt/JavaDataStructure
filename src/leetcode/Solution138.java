/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深度拷贝
 * 思想：拷贝这个链表，似的这两个链表互不干扰，且所有的指向顺序、值都一样
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while (node != null){
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        node = head;
        while(node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}

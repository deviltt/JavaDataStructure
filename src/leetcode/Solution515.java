/**
 * 您需要在二叉树的每一行中找到最大的值。
 * 输入:
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 * 输出: [1, 3, 9]
 */
package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//广度优先搜索
public class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null)
            return null;
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int num = queue.size();
            int max = queue.peek().val;
            for(int i = 0; i < num; i++) {
                if(queue.peek().left != null)
                    queue.add(queue.peek().left);
                if(queue.peek().right != null)
                    queue.add(queue.peek().right);
                int temp = queue.poll().val;
                max = temp > max ? temp : max;
            }
            list.add(max);
        }
        return list;
    }
}

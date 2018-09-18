package leetcode;

import java.util.*;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = true;
        while(!q.isEmpty()){
            //观察队列中有多少节点
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            //将队列中的节点依次出列
            for(int i = 0; i < size; i++){
                //1.保存出列的节点供后面访问节点
                root = q.poll();
                //2.将节点元素添加到list中
                list.add(root.val);
                //分别将左右节点入列
                if(root.left != null)
                    q.offer(root.left);
                if(root.right != null)
                    q.offer(root.right);
            }
            if(!flag)
                Collections.reverse(list);
            flag = !flag;
            res.add(list);
        }
        return res;
    }
}

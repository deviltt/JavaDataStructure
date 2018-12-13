package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：首先找到target节点，然后dfs以target为根节点的树，找出所有距离为K的节点，添加进入list
 *       其次，
 */
public class Solution863 {
    List<Integer> list;
    TreeNode target;
    int K;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        list = new ArrayList<>();
        this.target = target;
        this.K = K;
        dfs(root);
        return list;
    }
    private int dfs(TreeNode node){
        if(node == null)
            return -1;
        else if(node == target){
            subtree_add(node, 0);
            return 1;   //返回1表示与target节点最近的节点距离为1
        }
        else {
            int L = dfs(node.left);
            int R = dfs(node.right);
            /**
             * 要知道如果target节点在左子树中，则L != -1
             * 如果target节点在右子树中，则R != -1
             */
            if(L != -1){
                if(L == K)
                    list.add(node.val);
                subtree_add(node.right, L + 1);
                //返回上一层根节点与target节点的距离
                return L + 1;
            } //说明target在左子树上
            else if(R != -1){
                if(R == K)
                    list.add(node.val);
                subtree_add(node.left, R + 1);
                return R + 1;
            }
            else
                return -1;
        }
    }
    private void subtree_add(TreeNode node, int dist){
        if(node == null)
            return;
        if(dist == K)
            list.add(node.val);
        else{
            subtree_add(node.left, dist + 1);
            subtree_add(node.right, dist + 1);
        }
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        post(root, map);
        List<Integer> list = new ArrayList<>();
        for(Integer key : map.keySet()){
            if(map.get(key) == max)
                list.add(key);
        }
        int[] ret = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            ret[i] = list.get(i);
        return ret;
    }
    private int max = 0;

    private int post(TreeNode node, Map<Integer, Integer> map){
        //递归到底的情况，当节点为空时，返回0
        if(node == null)
            return 0;
        int leftSum = post(node.left, map);
        int rightSum = post(node.right, map);

        int sum = leftSum + rightSum + node.val;
        //用count计数，统计已经有多少个子树元素和了
        int count = map.getOrDefault(sum, 0) + 1;
        map.put(sum, count);
        max = max > count ? max : count;
        return sum;
    }
}

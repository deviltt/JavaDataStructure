/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //为啥要 nums.length + 1 呢,
        //问题出在地28行，如果输入[1],则list[1]实际长度是2
        List<Integer>[] list = new List[nums.length + 1];
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        for(int j : map.keySet()){
            int fre = map.get(j);
            if(list[fre] == null)
                list[fre] = new ArrayList<>();
            list[fre].add(j);
        }

        for(int pos = list.length; pos >= 0 && ans.size() < k; pos--){
            if(list[pos] != null)
                //这里使用addAll，因为频率为2的可能有多个
                ans.addAll(list[pos]);
        }
        return ans;
    }
}

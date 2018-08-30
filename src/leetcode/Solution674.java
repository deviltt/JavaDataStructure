/**
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 */

package leetcode;

public class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        int start = 0, max = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i - 1] >= nums[i])
                start = i;
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}

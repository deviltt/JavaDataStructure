/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [5,6]
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            while(nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]){
                //不能这样swap，因为第二步会改变nums[i]的值，第二步和第三步的nums[nums[i] - 1]的值不一样了
//                int temp = nums[i];
//                nums[i] = nums[nums[i] - 1];
//                nums[nums[i] - 1] = temp;
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i = 0; i < nums.length; i++)
            if(nums[i] != i + 1)
                list.add(i);

        return list;
    }
}

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，
 * 使得 A[i] + B[j] + C[k] + D[l] = 0
 */

/**
 * 算法思想：先计算任意两个数组的和，并把它们放进哈希表中
 * 再计算另外两个数组的和，如果存在满足题意的解，则其一定是哈希表中
 * 某个值的相反数
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                int sum = C[i] + D[j];
                if(map.containsKey(-sum))
                    ans += map.get(-sum);
            }
        }
        return ans;
    }
}

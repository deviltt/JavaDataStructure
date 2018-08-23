/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * 输入:
 * "tree"
 * 输出:
 * "eert"
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character>[] list = new List[s.length() + 1];
        List<Character> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for(char c : map.keySet()){
            int fre = map.get(c);
            if(list[fre] == null)
                list[fre] = new ArrayList<>();
            for(int i = 0; i < fre; i++)
                list[fre].add(c);
        }

        for(int pos = list.length - 1; pos >= 0; pos--)
            if(list[pos] != null)
                ans.addAll(list[pos]);
        for(char c : ans)
            str.append(c);
        return str.toString();
    }
}

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 示例 1:
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
package leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start != o2.start ? Integer.compare(o1.start, o2.start) : Integer.compare(o1.end, o2.end);
            }
        });
        LinkedList<Interval> list = new LinkedList<>();
        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start)
            list.add(intervals.get(i++));
        //跟新newInterval的区间
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval = new Interval(
                    Math.min(intervals.get(i).start, newInterval.start),
                    Math.max(intervals.get(i).end, newInterval.end));
            i++;
        }
        list.add(newInterval);
        while(i < intervals.size())
            list.add(intervals.get(i++));
        return list;
    }
}

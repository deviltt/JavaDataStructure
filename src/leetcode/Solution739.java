/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
 */
package leetcode;

import java.util.Stack;

public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = temperatures.length - 1; i >= 0; i--){
            //首先考虑其出栈的情况，即栈不为空且当前元素要比栈顶元素大的时候
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()])
                stack.pop();
            //当前元素的值：如果栈为空则为0，不为空用栈顶值减去当前索引
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}

/**
 * 你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 * 输入: ["5","2","C","D","+"]
 * 输出: 30
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到2分。总和是：7。
 * 操作1：第2轮的数据无效。总和是：5。
 * 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
 * 第4轮：你可以得到5 + 10 = 15分。总数是：30。
 */
package leetcode;

import java.util.Stack;

public class Solution682 {
    public int calPoints(String[] ops) {
        Stack<String> stack = new Stack<>();
        int sum = 0;

        for(String str : ops){
            switch (str){
                case "C":
                    int temp = Integer.parseInt(stack.pop());
                    sum -= temp;
                    break;
                case "D":
                    int a = Integer.parseInt(stack.peek());
                    stack.push(String.valueOf(2 * a));
                    sum += 2 * a;
                    break;
                case "+":
                    int b = Integer.parseInt(stack.pop());
                    int c = Integer.parseInt(stack.pop());
                    sum += b + c;
                    stack.push(String.valueOf(c));
                    stack.push(String.valueOf(b));
                    stack.push(String.valueOf(b + c));
                    break;
                    default:
                        stack.push(str);
                        sum += Integer.parseInt(str);
            }
        }
        return sum;
    }
}

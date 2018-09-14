/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 */
package leetcode;

import java.util.Stack;

public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;
                //如果括号匹配则出栈，不匹配直接返回false
                if(c == ')' && stack.peek() == '(' || c == ']' && stack.peek() == '[' || c == '}' && stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}

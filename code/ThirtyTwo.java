/**
 * Question Longest Valid Parentheses
 Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 Example 1:

 Input: "(()"
 Output: 2
 Explanation: The longest valid parentheses substring is "()"
 Example 2:

 Input: ")()())"
 Output: 4
 Explanation: The longest valid parentheses substring is "()()"

 */

import java.util.Stack;

public class ThirtyTwo {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] flag = new int[s.length()];
//        for(int num: flag)
//            num = 1;

        int length = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push(i);
            else if(!stack.empty()){
                int pre = stack.pop();
                flag[pre] = i;
            }
        }
        int tempLen = 0;
        for(int i = 0;i<s.length();i++){
            if(flag[i] == 0)
            {
                if(length<tempLen)
                    length = tempLen;
                tempLen = 0;
            }
            else {
                tempLen += flag[i]-i+1;
                i=flag[i];
            }
        }
        return length>tempLen? length: tempLen;
    }

    public static void main(String[] args){
        ThirtyTwo thirtyTwo = new ThirtyTwo();
        System.out.println(thirtyTwo.longestValidParentheses("(()"));
    }

}

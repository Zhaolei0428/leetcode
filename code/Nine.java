/**
 * Question
 Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

 Example 1:

 Input: 121
 Output: true
 Example 2:

 Input: -121
 Output: false
 Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 Example 3:

 Input: 10
 Output: false
 Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 Follow up:

 Coud you solve it without converting the integer to a string?
 */

import java.util.Scanner;

public class Nine {
    /**
     * my solution, the answer in leetcode is better, O(log n)
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x < 10) return true;
        int up = x/10;
        int down = x%10;
        int reverseUp = 0;
        while(x >= 10){
            reverseUp = 10*reverseUp + x%10;
            x /= 10;
        }
        if(x == down && up == reverseUp)
            return true;
        else
            return false;
    }

    public static void main(String[] arg){
        System.out.println(Integer.MAX_VALUE);
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Nine nine = new Nine();
        System.out.println(nine.isPalindrome(num));
    }

}

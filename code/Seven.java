/**
 * Question
 *
 Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output: 321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21
 Note:
 Assume we are dealing with an environment which could only store integers
 within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose
 of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

import java.util.Scanner;

public class Seven {
//    public int reverse(int x) {
//        System.out.println(Integer.MAX_VALUE);
//        int sign = 1;
//        if(x<0)
//            sign = -1;
//        long lx = Math.abs((long)x);
//        long nlx = 0;
//        while(lx != 0){
//            nlx = 10 * nlx + lx%10;
//            lx = lx/10;
//        }
//        if(sign == 1 && nlx > Math.pow(2,31)-1)
//            nlx = 0;
//        if(sign == -1 && nlx > Math.pow(2,31))
//            nlx = 0;
//        return (int)(sign*nlx);
//    }

    /**
     * 官方答案，上面是自己的答案
     * @param x
     * @return
     */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
    public static void main(String[] args){
        Seven seven = new Seven();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(seven.reverse(n));
    }
}

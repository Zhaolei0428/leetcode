/**
 *
 The string "PAYPALISHIRING" is written in a zigzag（蜿蜒） pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string s, int numRows);
 Example 1:

 Input: s = "PAYPALISHIRING", numRows = 3
 Output: "PAHNAPLSIIGYIR"
 Example 2:

 Input: s = "PAYPALISHIRING", numRows = 4
 Output: "PINALSIGYAHRPI"
 Explanation:

 P     I    N
 A   L S  I G
 Y A   H R
 P     I
 */

import java.util.Scanner;

public class Six {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        int firstHop = 0;
        int secondHop = 0;
        int sLen = s.length();
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<numRows && i<sLen; i++)
        {
            sb.append(s.charAt(i));
            firstHop = 2*(numRows-i-1);
            secondHop = 2*i;
            int k =i;
            while(k<sLen)
            {
                k += firstHop;
                if(firstHop!=0 && k<sLen)
                    sb.append(s.charAt(k));
                k += secondHop;
                if(secondHop!=0 && k<sLen)
                    sb.append(s.charAt(k));
            }
        }
        String ns = new String(sb);
        return ns;
    }

    public static void main(String[] args){
        Six six = new Six();
        Scanner in = new Scanner(System.in);
        String inS = in.nextLine();
        int numRows = in.nextInt();
        String s = six.convert(inS, numRows);
        System.out.println(s);
    }
}

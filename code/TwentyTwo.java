import java.util.ArrayList;
import java.util.List;

/**
 * Question
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]

 */
public class TwentyTwo {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        res = new ArrayList<>();
        generate(n,n,sb);
        return res;
    }

    public void generate(int pre, int back, StringBuilder sb){
        if(pre==0 && back==0){
            res.add(sb.toString());
            return;
        }
        if(pre == back){
            sb.append('(');
            generate(pre-1, back, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        else {
            if(pre != 0) {
                sb.append('(');
                generate(pre -1, back, sb);
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(')');
            generate(pre, back-1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args){
        TwentyTwo twentyTwo = new TwentyTwo();
        System.out.println(twentyTwo.generateParenthesis(3));
    }
}

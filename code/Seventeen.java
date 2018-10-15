import java.util.ArrayList;
import java.util.List;

public class Seventeen {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0)   return res;
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        letterCombinations(digits, mapping, res, new StringBuilder(), 0);
        return res;
    }

    private void letterCombinations(String digits, String[] mapping, List<String> res, StringBuilder sb, int i) {
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int digit = Character.getNumericValue(digits.charAt(i));
        for (int j = 0; j < mapping[digit].length(); j++) {
            sb.append(mapping[digit].charAt(j));
            letterCombinations(digits, mapping, res, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args){
        Seventeen seventeen = new Seventeen();
        List<String> out = seventeen.letterCombinations("3456");
        for (String each: out){
            System.out.println(each);
        }
    }

}

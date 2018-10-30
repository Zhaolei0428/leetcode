public class FourtyFour {
    int[][] flag;
    public boolean isMatch(String s, String p) {
        StringBuilder sb = new StringBuilder();
        char pre = '0';
        for(int i=0; i< p.length(); i++) {
            if(!(pre == '*' && p.charAt(i) == '*'))
                sb.append(p.charAt(i));
            pre = p.charAt(i);
        }
        p = sb.toString();
        System.out.println(p);
        flag = new int[s.length()+1][p.length()+1];
        return oneMatch(s, p, 0, 0);
    }

    public boolean oneMatch(String s, String p, int i, int j) {
        if(flag[i][j] == 1)
            return true;
        if(flag[i][j] == 2)
            return false;
        if(i == s.length()) {
            if(j == p.length())
                return true;
            else if(p.charAt(j) == '*')
                return oneMatch(s, p, i, j+1);
            else
                return false;
        }
        if(j == p.length())
            return false;
        boolean result;
        if(p.charAt(j) == '*') {
            result = oneMatch(s, p, i, j+1) || oneMatch(s, p, i+1, j);
            if(result)
                flag[i][j] = 1;
            else
                flag[i][j] = 2;
            return result;
        }
        else if(p.charAt(j) == '?'){
            result = oneMatch(s, p, i+1, j+1);
            if(result)
                flag[i][j] = 1;
            else
                flag[i][j] = 2;
            return result;
        }
        else {
            if(s.charAt(i) == p.charAt(j)) {
                result = oneMatch(s, p, i+1, j+1);
                if(result)
                    flag[i][j] = 1;
                else
                    flag[i][j] = 2;
                return result;
            }
            else
                return false;
        }
    }

    public static void main(String[] args) {
        FourtyFour fourtyFour = new FourtyFour();
        System.out.println(fourtyFour.isMatch("aaaaabbbbabababbabbbbbababbbbbabba", "a*********b***b***a***b"));
    }
}

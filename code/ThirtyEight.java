public class ThirtyEight {
    public String countAndSay(int n) {
        if(n == 0)
            return "";
        StringBuilder sb = new StringBuilder("1");
        for(int i=1; i<n; i++){
            StringBuilder newSb = new StringBuilder("");
            int num = 1;
            char ch = sb.charAt(0);
            for(int j=1; j< sb.length(); j++){
                if(sb.charAt(j) == ch){
                    num++;
                }
                else {
                    newSb.append(num);
                    newSb.append(ch);
                    num = 1;
                    ch = sb.charAt(j);
                }
            }
            newSb.append(num);
            newSb.append(ch);
            sb = newSb;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        ThirtyEight thirtyEight = new ThirtyEight();
        System.out.println(thirtyEight.countAndSay(4));
    }
}

public class Fourteen {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        int minLen = strs[0].length();
        for(String str: strs){
            if(minLen>str.length())
                minLen = str.length();
        }
        for(int i = 0; i<minLen; i++){
            char ch = strs[0].charAt(i);
            for(String str: strs){
                if(str.charAt(i)!=ch)
                    return str.substring(0,i);
            }
        }
        return strs[0].substring(0, minLen);
    }
    public static void main(String[] args){
        System.out.println("asd".substring(0,0).equals("")? 0: 1);
    }
}

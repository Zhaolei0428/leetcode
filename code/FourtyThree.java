public class FourtyThree {
    public String multiply(String num1, String num2) {
        if(num1 == "0" || num2 == "0")
            return "0";
        if(num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        String result = "0";
        String location = "";
        for(int i = num2.length()-1; i >=0; i--) {
            if(num2.charAt(i) != '0')
                result = addString(singleMultiply(num1, num2.charAt(i)-'0') + location, result);
            location += "0";
        }
        return result;
    }

    /**
     * a string nultiply a single character
     * @param num1
     * @param num2
     * @return result
     */
    public String singleMultiply(String num1, int num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i=num1.length()-1; i >=0; i--) {
            int multiplier = num1.charAt(i) - '0';
            int sum = multiplier * num2 + carry;
            carry = sum/10;
            sb.append(sum%10);
        }
        if(carry!=0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    /**
     * string add, num1 > num2
     * @param num1
     * @param num2
     * @return result
     */
    public String addString(String num1,  String num2) {
        StringBuilder sb = new StringBuilder(num1);
        sb.reverse();
        int len = num2.length();
        int carry = 0;
        for(int i = len-1; i>=0; i--) {
            int sum = num2.charAt(i)-'0' + sb.charAt(len-i-1) - '0' + carry;
            carry = sum/10;
            sb.replace(len-i-1, len-i, String.valueOf(sum%10));
        }
        for(int i = len; i<sb.length(); i++) {
            if(carry==0)
                break;
            int sum = sb.charAt(i) - '0' + carry;
            carry = sum/10;
            sb.replace(i, i+1, String.valueOf(sum%10));
        }
        if(carry!=0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        FourtyThree fourtyThree = new FourtyThree();
        System.out.println(fourtyThree.multiply("65539", "83314"));
    }

}

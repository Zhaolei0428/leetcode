import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Twenty {
    public boolean isValid(String s) {
        Map<String,String> map = new HashMap<>();
        map.put("(",")");
        map.put("[","]");
        map.put("{","}");
        Stack<String> stack = new Stack();
        stack.push("#");
        for(int i = 0; i<s.length(); i++){
            String str = s.substring(i, i+1);
            if(str.equals(map.get(stack.peek()))){
                stack.pop();
            }
            else if(map.containsKey(str)){
                stack.push(str);
            }
            else {
                return false;
            }
        }
        if(stack.pop().equals("#"))
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        Twenty twenty = new Twenty();
        System.out.println(twenty.isValid("({)"));
    }

}

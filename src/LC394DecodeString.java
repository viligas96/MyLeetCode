import java.util.*;
public class LC394DecodeString {
    public static String charType(char i){
        if (i == '[') return "leftBracket";
        if (i == ']') return "rightBracket";

        return "number";
    }

    public static String decodeString(String s) {
        StringBuilder ret = new StringBuilder();
        Stack<String> stack = new Stack<>();
        StringBuilder cur = new StringBuilder();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (charType(c).equals("rightBracket")) {
                while(!stack.peek().equals("[")) {
                    cur.insert(0, stack.pop());
                }
                stack.pop();
                String tmp = cur.toString();

                StringBuilder repeat = new StringBuilder();
                while (charType(stack.peek().charAt(0)).equals("number")){
                    repeat.insert(0, stack.pop());
                    if (stack.size() == 0)break;
                }
                int rep = Integer.parseInt(repeat.toString());

                cur.append(tmp.repeat(rep - 1));
                stack.push(cur.toString());
                cur = new StringBuilder();

            } else{
                stack.add(c+ "");
            }
        }
        while (!stack.empty()){
            ret.insert(0, stack.pop());
        }
        return ret.toString();
    }

    public static void main(String[] args){

        System.out.println(decodeString("5[leetcode]"));
    }
}

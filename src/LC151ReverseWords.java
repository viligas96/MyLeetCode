import java.util.*;
public class LC151ReverseWords {
    public static String reverseWords(String s) {

        StringBuilder cur = new StringBuilder();
        Stack<StringBuilder> stack = new Stack<>();

        int len = s.length();

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' '){
                if (cur.length() == 0)continue;
                System.out.println(cur.length());
                stack.add(cur);
                cur = new StringBuilder();
            } else{
                cur.append(s.charAt(i));
            }
        }

        stack.add(cur);

        StringBuilder ret = new StringBuilder();

        while (!stack.empty()){
            ret.append(stack.pop());
            ret.append(" ");
        }

        ret.deleteCharAt(ret.length()-1);
        return ret.toString();
    }

    public String reverse(StringBuilder words){
       StringBuilder ret = new StringBuilder();
       ret.append(words);
       return ret.reverse().toString();
    }

    public static void main(String[] args){
        System.out.println(reverseWords("  hello world  "));




    }
}

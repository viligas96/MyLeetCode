import java.util.*;
public class LC227BasicCaculatorII {
    public static int calculate(String s) {
        int len = s.length();
        if (len == 1) return Integer.parseInt(s);

        Stack<String> expression = new Stack<>();
        String cur = "";

        for (int i = 0; i < len; i++){
            if (s.charAt(i) == ' ') continue;
            if (expression.empty() || expression.peek().equals("*") || expression.peek().equals("/")
                    || expression.peek().equals("+")|| expression.peek().equals("-")){
                cur += s.charAt(i);
                if (i != len - 1 && (s.charAt(i + 1) - '0' >= 0 && s.charAt(i + 1)- '0' <= 9)){
                    continue;
                }
                if (!expression.empty() && expression.peek().equals("*")){
                    expression.pop();
                    cur = Integer.parseInt(expression.pop()) * Integer.parseInt(cur) + "";
                }
                if (!expression.empty() && expression.peek().equals("/")){
                    expression.pop();
                    cur = Integer.parseInt(expression.pop()) / Integer.parseInt(cur) + "";
                }
                expression.push(cur);
                cur = "";
            } else {
                expression.push(s.charAt(i) + "");
            }
        }

        int ret = 0;
        int tmp = 0;

        System.out.println(expression);

        while (expression.size() != 0){
            if (expression.size() == 1){
                ret += Integer.parseInt(expression.pop());
                break;
            }
            if (!expression.peek().equals("+") && !expression.peek().equals("-")){
                tmp = Integer.parseInt(expression.pop());
            } else if (expression.peek().equals("+")){
                expression.pop();
                ret += tmp;
            } else if (expression.peek().equals("-")){
                expression.pop();
                ret -= tmp;
            }
        }
        return ret;
    }

    public static int calculate2(String s) {
        s = transfer(s);
        int len = s.length();
        if (len == 1) return Integer.parseInt(s);

        int ret = 0;
        String cur = "";
        String tmp = "";
        boolean mu = false;
        boolean div = false;

        for (int i = 0; i < len; i++){
            char ch = s.charAt(i);
            if (s.charAt(i) == ' ')continue;
            if (!isOp(ch)){
                if (!mu && !div) {
                    cur += ch;
                } else {
                    tmp += ch;
                }
            } else {
                if (mu){
                    cur = Integer.parseInt(cur) * Integer.parseInt(tmp) + "";
                    tmp = "";
                    mu = false;
                }
                if (div){
                    cur = Integer.parseInt(cur) / Integer.parseInt(tmp) + "";
                    tmp = "";
                    div = false;
                }
                if (ch == '+' || ch == '-') {
                    ret += Integer.parseInt(cur);
                    cur = ch == '+' ? "" : "-";
                } else {
                    if (ch == '*'){
                        mu = true;
                        System.out.println(i);
                        System.out.println(cur);
                    } else {
                        div = true;
                    }
                }
            }

            if (i == len - 1){
                if (mu){
                    cur = Integer.parseInt(cur) * Integer.parseInt(tmp) + "";
                }
                if (div){
                    cur = Integer.parseInt(cur) / Integer.parseInt(tmp) + "";
                }
                ret += Integer.parseInt(cur);
                break;
            }
        }

        return ret;
    }

    public static boolean isOp(char i){
        return i == '-' || i == '+' || i == '*' || i == '/';
    }

    public static String transfer(String s){
        String ret = "";
        for (char i: s.toCharArray()){
            if (i != ' '){
                ret += i;
            }
        }
        return ret;
    }

    public static void main(String[] args){
        System.out.println(calculate2(" 3/2 "));
    }
}

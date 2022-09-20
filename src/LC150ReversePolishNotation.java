import java.util.*;
public class LC150ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < tokens.length; i++){
            switch(tokens[i]){
                case "*":
                    int tmp1 = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(tmp1));
                    break;
                case "/":
                    int in1 = Integer.parseInt(stack.pop());
                    int in2 = Integer.parseInt(stack.pop());
                    int tmp2 = in2 / in1;
                    stack.add(String.valueOf(tmp2));
                    break;
                case "+":
                    int tmp3 = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(tmp3));
                    break;
                case "-":
                    int tmp4 = Integer.parseInt(stack.pop()) - Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(tmp4));
                    break;
                default:
                    stack.add(tokens[i]);
                    break;
            }
            if (i == tokens.length - 1){
                res = Integer.parseInt(stack.pop());
            }
        }
        return res;
    }
}

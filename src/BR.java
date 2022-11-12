import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class BR {


    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

        int i = 0; //for '['
        int j = 0; //for '('
        int k = 0; //for '{'

        Stack<Character> stack = new Stack<>();
        line = in.readLine();
        boolean tmpValid = true;
        while (line != null) {
            int len = line.length();
            for (int index = 0; index < len; index++){
                char cur = line.charAt(index);
                if (cur != '[' && cur != ']' && cur != '{' && cur != '}' && cur != '(' && cur != ')')continue;

                if (cur == '['){
                    stack.push(cur);
                    i++;
                    continue;
                }
                if (cur == '('){
                    stack.push(cur);
                    j++;
                    continue;
                }
                if (cur == '{'){
                    stack.push(cur);
                    k++;
                    continue;
                }
                if (cur == ']'){
                    char tmp = stack.pop();
                    if (tmp != '['){
                        tmpValid = false;
                        break;
                    }
                    i--;
                    continue;
                }
                if (cur == ')'){
                    char tmp = stack.pop();
                    if (tmp != '('){
                        tmpValid = false;
                        break;
                    }
                    j--;
                    continue;
                }
                if (cur == '}'){
                    char tmp = stack.pop();
                    if (tmp != '{'){
                        tmpValid = false;
                        break;
                    }
                    k--;
                }
            }
            if (tmpValid){
                line = in.readLine();
            } else{
                break;
            }
        }
        if (tmpValid && i == 0 && j == 8 && k ==0){
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
    }
}

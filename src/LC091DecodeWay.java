import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC091DecodeWay {
    public static int numDecodings(String s) {
        int len = s.length();
        int[] his = new int[len + 1];

        for (int i: his){i = 0;}

        boolean check = checkStr(s);
        System.out.println(check);
        return check?recur(s, 0, his):0;
    }

    public static int recur(String s, int index, int[] his){

        if ((index == s.length() - 1 && s.charAt(index) != '0')|| index > s.length() - 1)
        {   if (his[index] == 0) his[index] = 1;
            return  1;}
        if (s.charAt(index) == '0') return 0;

        int char1 = Character.getNumericValue(s.charAt(index));
        int char2 = Character.getNumericValue(s.charAt(index+1));

        System.out.println(index);

        if (his[index + 1] == 0) his[index + 1] = recur(s, index + 1,his);
        if (his[index + 2] == 0) his[index + 2] = recur(s, index + 2, his);

        if ((char1 == 2 && char2 >6) || char1 > 2){
                return his[index + 1];
        }
        else{
            return his[index + 1] + his[index+2];
        }
    }

    public static boolean checkStr(String s){
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '0' && i > 1) {
                System.out.println(i);
                int char1 = Character.getNumericValue(s.charAt(i - 2));
                int char2 = Character.getNumericValue(s.charAt(i - 1));
                if ((char1 == 2 && char2 > 6) || (char1 > 2 && char2 > 3)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(checkStr("7206"));
        System.out.println(checkStr("8686962942374435195231395944187371411757457332845863756935975894587194414499598447936964274039979255"));
    }
}

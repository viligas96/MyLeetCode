import java.util.*;
public class LC066PlusOne {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;

        digits[len-1]++;
        if (digits[len-1] != 10){ return digits;}

        for (int i = len - 1; i >= 0; i--){
            if (i == 0){
                if (digits[0] == 10){
                int[] ret = new int[len + 1];
                for (int num: ret){
                    num = 0;
                }
                ret[0] = 1;
                return ret;
                }
                else{
                    break;
                }
            }
            if (digits[i] == 10){
                digits[i] = 0;
                digits[i - 1]++;
            } else{
                return digits;
            }
        }
        return digits;
    }
    public static void main (String[] args){

        System.out.println(Arrays.toString(plusOne(new int[]{1, 9,4, 9, 9})));
    }
}

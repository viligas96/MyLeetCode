import java.util.*;

public class LC069Sqrt {
    public static int mySqrt(int x) {
        if (x== 0) return 0;
        if (x== 2) return 1;

        // get digits of x
        int first_digit = 1;
        int digit = 0;
        int num = x;


        while (num!= 0){
            if (num < 10)first_digit = num;
            num/= 10;
            digit += 1;
        }
        // get start point of our try;
        int start = 1;
        while (digit > 1){
            start *= 3;
            digit--;
        }
        if (first_digit == 9){start *= 3;}
        if (first_digit < 9 && first_digit >= 4){start *= 2;}

        //try from start point;
        for (long i = (long)start; i < x; i++){
            if ((i*i >= Integer.MAX_VALUE) || (i * i) > x){
                return (int)i -1;
            }
        }
        return x;
    }
    public static void main (String[] args){

        System.out.println(mySqrt(2147483647));
    }
}

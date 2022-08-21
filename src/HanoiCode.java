import java.util.*;
import java.lang.*;

public class HanoiCode{

    public static class Hanoi{
        public Hanoi(int N) {
            func(N, "left", "right", "mid");
        }

        public void func(int n, String from, String to, String other){
            if (n == 1){
                System.out.println("Move " + 1 +" "+ from + " to " + to);
            }
            else {
                func(n- 1, from, other, to);
                System.out.println("Move " + n + " " + from + " to " + to);
                func(n - 1, other, to, from);
            }
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        Hanoi han = new Hanoi(5);
        int[] a = {1,0,0,0,-1};
        int[] b = a.clone();
        Arrays.sort(b);

        String digits = "123";
        int num = Character.getNumericValue(digits.charAt(1));
        //System.out.println(num);
        //System.out.println(sol.threeSum(]);
    }
}



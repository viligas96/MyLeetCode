import java.util.Arrays;

public class LC172FactorialZero {
    public static int trailingZeroes(int n) {
        int[] num = new int[6];
        num[0] = 1;
        num[1] = 6;
        for (int i = 2; i < 6; i++){
            num[i] = (num[i - 1] - 1)*5 + 1;
        }
        System.out.println(Arrays.toString(num));
        return recur(n, num);
    }
    public static int recur(int n, int[] num){
        if (n < 5)return 0;

        int i = 0;
        int k = n;
        while (k >= 5){
            k /= 5;
            i++;
        }

        int cur = (int)Math.pow(5, i);

        return num[i - 1] + recur(n - cur, num);
    }
    public static void main(String... args){
        System.out.println(trailingZeroes(150));
    }
}
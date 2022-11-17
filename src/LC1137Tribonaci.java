import java.util.*;
public class LC1137Tribonaci {
    public int tribonacci(int n) {
        if (n == 0)return 0;
        if (n == 1 || n == 2)return 1;
        int[] dp = new int[n  + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        return tripo(n, dp);
    }

    public int tripo(int n, int[] dp){
        if (n < 0)return 0;
        if (dp[n] != -1) return dp[n];


        int ret =  tripo(n-1, dp) + tripo(n-2, dp) + tripo(n-3, dp);
        dp[n] = ret;
        return ret;
    }
}

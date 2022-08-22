import java.util.Arrays;

public class LC062UniquePath {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++){
            dp[0][j] = 1;
        }

        for (int ind1 = 1; ind1< m; ind1++){
            for (int ind2 = 1; ind2 < n; ind2++){
                dp[ind1][ind2] = dp[ind1 - 1][ind2] + dp[ind1][ind2 - 1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main (String[] args){

        System.out.println(uniquePaths(3,7));
    }
}

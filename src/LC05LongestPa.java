import java.util.*;

public class LC05LongestPa {
    static class Solution {
        public Solution(){
        }
        public String longestPalindrome(String s) {
            int len = s.length();

            if (len == 1){
                return s;
            }
            if (len == 2){
                return s.charAt(0) == s.charAt(1)? s:s.substring(0,1);
            }

            int max_len = 1;
            String ret = "" + s.charAt(0);

            boolean[][] dp = new boolean[len][len];
            for (int  i= 0; i < len; i++){
                dp[i][i] = true;
                if (i+1 < len){
                    dp[i][i+1] = s.charAt(i) == s.charAt(i + 1);
                    if (dp[i][i+1] && max_len != 2){
                        max_len = 2;
                        ret = s.substring(i,i+2);
                    }
                }
            }
            for (int k = 2; k < len; k++){
                for (int j = 0; j < len - k; j++){
                    dp[j][j+k] = dp[j+1][j+k -1] && s.charAt(j) == s.charAt(j+k);
                    if (k + 1> max_len && dp[j][j + k]){
                        max_len = k + 1;
                        ret = s.substring(j, j+k+1);
                    }
                }
            }
            return ret;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("babad"));
    }
}


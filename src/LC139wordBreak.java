import java.util.*;
public class LC139wordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i =0; i < s.length(); i++){
            dp[i] = true;
        }

        return recur(s, 0, wordDict, dp);
    }

    public static boolean recur(String s, int i, List<String> wordDict, boolean[] dp){
        if (i >= s.length() - 1){
            return true;
        }
        if (!dp[i])return false;

        boolean ret = false;
        for (String str: wordDict){
            if (isMatch(s.substring(i), str)){
                System.out.println(s.substring(i));
                int len = str.length();
                ret = ret|| recur(s, i+len,wordDict,dp);
            }
        }

        if (!ret)dp[i] = false;
        return ret;
    }

    public static boolean isMatch(String s, String word){
        for (int i = 0; i < word.length(); i++){
            if (i > s.length() || word.charAt(i) != s.charAt(i)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        String s = "cars";
        List<String> wordDict = Arrays.asList( "car","ca", "rs");
        System.out.println(wordBreak(s,wordDict));

        String i = "123";
        String i2 = "1";
        System.out.println(i.substring(1));
    }
}

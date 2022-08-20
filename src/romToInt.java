import java.util.*;

public class romToInt {
    static class Solution {
        public int romanToInt(String s) {
            int ret = 0;

            for (int i = 0; i < s.length(); i++){
                switch (s.charAt(i)){
                    case 'M': ret += 1000;

                }
            }
            return 0;
        }
    }
    public static void main(String[] args){
        LongestP.Solution sol = new LongestP.Solution();
        System.out.println();
    }
}

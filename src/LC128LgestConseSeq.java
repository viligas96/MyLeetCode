import java.util.*;
public class LC128LgestConseSeq {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0)return 0;
        if (nums.length == 1)return 1;

        HashSet<Integer> num = new HashSet<>();

        for (int n: nums){num.add(n);}

        int retStreak = 1;

        for (int n: num){
            if (!num.contains(n-1)){
                int curStreak = 1;

                int i = n;
                while (num.contains(i+1)){
                    curStreak++;
                    i++;
                }
                retStreak = Math.max(curStreak, retStreak);
            }
        }
        return retStreak;
    }

    public static void main(String[] args){
        System.out.println(longestConsecutive(new int[]{4,34,5,6,7}));
    }
}

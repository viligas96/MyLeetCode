import java.util.*;

public class LC506RelativeRank {
    public static String[] findRelativeRanks(int[] score) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = score.length;

        for (int i = 0; i < len; i++){
            map.put(score[i], i);
        }

        String[] ret = new String[len];
        Arrays.sort(score);

        for (int i = 0; i < len; i++){
            int rank = len - i;
            int index = map.get(score[i]);

            if (rank == 1){
                ret[index] = "Gold Medal";
            }
            if (rank == 2){
                ret[index] = "2nd";
            }
            if (rank == 3){
                ret[index] = "3rd";
            }
            ret[index] = rank + "th";

        }
        return ret;
    }

    public static void main(String[] args){
        for (String s: findRelativeRanks(new int[]{4,5,3,2,1})) {
            System.out.println(s);
        }
    }
}

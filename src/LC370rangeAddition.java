import java.util.*;

public class LC370rangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ret = new int[length];

        for (int[] arr: updates){
            for (int i = arr[0]; i <= arr[1]; i++){
                ret[i]+= arr[2];
            }
        }

        //Arrays.fill(ret, -1);
        return ret;
    }
}

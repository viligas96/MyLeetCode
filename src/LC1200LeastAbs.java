import java.util.*;
public class LC1200LeastAbs {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int[] diff = new int[len - 1];
        for (int i = 0; i < len - 1; i++){
            diff[i] = arr[i + 1] - arr[i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len - 1; i++){
            if (diff[i] < min) min = diff[i];
        }

        List<List<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < len - 1; i++){
            if (arr[i+1] - arr[i] == min){
                List<Integer> cur = new ArrayList<>();
                cur.add(arr[i]);
                cur.add(arr[i+1]);
                ret.add(cur);
            }
        }
        return ret;
    }
}

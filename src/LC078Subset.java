import java.util.*;
public class LC078Subset {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        boolean[] bool = new boolean[nums.length];
        recur(nums, ret, bool, 0);
        return ret;
    }

    public static void recur(int[] nums, List<List<Integer>> ret, boolean[] bool, int i){
        if (i == nums.length){
            List<Integer> res = new ArrayList<>();
            for (int j = 0; j < nums.length; j++){
                if (bool[j]){
                    res.add(nums[j]);
                }
            }
            ret.add(res);
            return;
        }
        bool[i] = false;
        recur(nums, ret, bool, i + 1);
        bool[i] = true;
        recur(nums, ret, bool, i + 1);

    }

    public static void main(String[] args){

        System.out.println(subsets(new int[]{1,2,3 }));
    }


}

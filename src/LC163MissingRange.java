import java.util.*;
public class LC163MissingRange {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ret = new LinkedList<>();
        int len = nums.length;
        if (len ==0){
            if (lower == upper){
                ret.add(lower+"");
                return ret;
            } else {
                ret.add(lower+"->"+upper);
            }
        }
        int lowest = lower;

        for (int i = 0; i < len; i++){
            if (nums[i] != lowest ){
                if (nums[i] - lowest == 1){
                    ret.add((lowest + ""));
                } else{
                    ret.add(lowest + "->" + (nums[i]-1));

                }
            }

            lowest = nums[i] + 1;

            if (i == len -1 && nums[i] < upper){
                if (upper - nums[i] == 1){
                    ret.add(upper + "");
                } else {
                    ret.add((nums[i]+1) + "->" + upper);
                }
            }
        }
        return ret;
    }
}

import java.util.Arrays;

public class LC169MajorElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }


    public static void main(String... argsd){
    }
}

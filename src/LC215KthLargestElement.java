import java.util.Arrays;

public class LC215KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (k <= len/2) {
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < len - 1 - i; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int tmp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = tmp;
                    }
                }
            }
        } else {
            for (int i = 0; i < len - k + 1; i++){
                for (int j = len - 1; j > i; j--){
                    if (nums[j] < nums[j - 1]) {
                        int tmp = nums[j];
                        nums[j] = nums[j - 1];
                        nums[j - 1] = tmp;
                    }
                }
            }
        }
            return nums[len - k];
    }

    public static void main(String... args) {
        int[] nums = new int[]{7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(findKthLargest(nums, 5));
    }
}
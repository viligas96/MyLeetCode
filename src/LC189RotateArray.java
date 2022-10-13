public class LC189RotateArray {
    public void rotate(int[] nums, int k) {
        int len = nums.length;

        if (k >= len) {
            k = k - len*(k/len);}
        if (k == 0)return;
        int[] ret = new int[len];

        for (int i = k; i < len; i++){
            ret[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++){
            ret[i] = nums[len - k + i];
        }
        for (int i = 0; i < len;i++){
            nums[i] = ret[i];
        }
    }
}

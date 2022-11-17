public class LC560SubarraySumK {
    public static int subarraySum(int[] nums, int k) {
        int len = nums.length;

        int[] sum = new int[len + 1];
        sum[0] = 0;

        for (int i = 1; i < len + 1; i++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int ret = 0;

        for (int i = 0; i < len + 1; i++){
            for (int j = i + 1; j < len + 1; j++){
                if ((sum[j] - sum[i]) % k == 0) {
                    ret++;
                }
            }
        }

        return ret;
    }
    public static void main(String[] args){
            System.out.println(subarraySum(new int[]{1,2,3}, 3));
    }
}

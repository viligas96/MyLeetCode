public class LC268MissingNum {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i: nums){
            sum += i;
        }
        return len * (len+1) / 2 - sum;
    }
}

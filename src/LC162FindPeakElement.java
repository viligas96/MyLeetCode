public class LC162FindPeakElement {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        if (len == 2) return nums[1] > nums[0]? 1:0;

        if (nums[0] > nums[1])return 0;

        for (int i = 1; i < len - 1; i++){
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]){
                return i;
            }
        }



        int front = 0;
        int end = len - 1;
        int mid = (front + end)/2;




        return len - 1;
    }
}

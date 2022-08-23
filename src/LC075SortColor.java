class LC075SortColor {
    public void sortColors(int[] nums) {
        int len = nums.length;

        int left = 0;
        int mid = 0;
        int right = len-1;

        while (mid <= right){
            if (nums[mid] == 1){
                mid++;
            }
            else if (nums[mid] == 2){
                swap(nums, mid,right);
                right--;
            }
            else if (nums[mid] == 0){
                swap(nums,left,mid);
                left++;
                mid++;
            }

        }
    }
    public static void swap(int[] nums, int i, int j){
        if (i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
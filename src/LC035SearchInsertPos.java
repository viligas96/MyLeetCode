public class LC035SearchInsertPos {
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (nums[len - 1] < target)return len;
        if (nums[0] >= target) return 0;

        int start = 0;
        int end = len - 1;
        int mid = (start + end)/2;

        while (mid != start){
            if (nums[mid] > target){
                end = mid;
                mid = (start+end)/2;
            } else if(nums[mid] == target){
                return mid;
            } else{
                start = mid;
                mid = (start + end)/2;
            }
        }
        return mid + 1;
    }

    public static void main(String[] args){
        int[] test = new int[]{1,3,};
        System.out.println(searchInsert(test, 1));
    }
}

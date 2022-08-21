public class LC034FindFirstAndLast {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 1){
            return nums[0]==target?new int[]{0,0}:new int[]{-1,-1};
        }

        int front = 0;
        int mid;
        int end = nums.length - 1;

        int tar = -1;

        while (front <= end) {
            mid = (front + end) >>> 1;
            if (target == nums[mid]) {
                tar = mid;
                break;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                front = mid + 1;
            }
        }

        if (tar == -1){
            return new int[]{-1,-1};
        }

        return new int[]{searchL(nums, front, tar), searchR(nums, tar, end)};
    }

    public static int searchL(int[] nums, int start, int index){
        if (start >= index){
            return index;
        }

        int mid = (start + index + 1)/2;

        if (nums[mid] == nums[index] && nums[mid] != nums[mid - 1]){
            return mid;
        }
        if (nums[mid] < nums[index]){
            return searchL(nums, mid + 1, index);
        } else{
            return searchL(nums, start, mid-1);
        }
    }

    public static int searchR(int[] nums, int index, int end){
        if (index >= end){
            return end;
        }
        int mid = (index + end - 1)/2;

        if ((nums[mid] == nums[index] && nums[mid] != nums[mid +1])){
            return mid;
        }
        if (nums[mid] > nums[index]){
            return searchR(nums, index, mid -1);
        } else{
            return searchR(nums, mid+1, end);
        }
    }

    public static void main(String[] args){
        System.out.println(searchRange(new int[]{1,4}, 4)[0]);
        System.out.println(searchRange(new int[]{1,4}, 4)[1]);
    }
}

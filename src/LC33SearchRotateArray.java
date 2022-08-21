public class LC33SearchRotateArray {
    public static int search(int[] nums, int target) {
        if (nums.length == 1){
            return nums[0] == target?0:-1;
        }
        int front = 0;
        int mid = (nums.length - 1)/2;
        int end = nums.length - 1;

        if (nums[front] == target){
            return front;
        }
        if (nums[end] == target){
            return end;
        }

        boolean bsearch = false;

        while (mid != end && mid != front){
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] > nums[end]){
                if (target > nums[end] && target < nums[mid]){
                    bsearch = true;
                    end = mid;
                    mid = (front+end)/2;
                    break;
                }
                else{
                    front = mid;
                }
            }
            else{
                if (target > nums[mid] && target < nums[end]){
                    bsearch = true;
                    front = mid;
                    mid = (front + end)/2;
                    break;
                }
                else{
                    end = mid;
                }
            }
            mid = (front + end)/2;
        }

        if (bsearch){
            while (mid != end && mid != front){
                if (nums[mid] == target){
                    return mid;
                }
                if (nums[mid] > target){
                    end = mid;
                }
                else{
                    front = mid;
                }
                mid = (front + end)/2;
            }

        }

        return -1;
    }

    public static void main(String[] args){
    }
}

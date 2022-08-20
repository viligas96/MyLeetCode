public class removeDuplicate {
    static class Solution {
        public int removeDuplicates(int[] nums) {
            int len = nums.length;
            int i = 0;
            int j = 0;


            if (len == 1){
                return 1;
            }

            while(j <= len -1){
                if (nums[j] == nums[i]){
                    j++;
                    if (i >= 1 && nums[i] <= nums[i -1]){
                        continue;
                    }
                    i++;
                }
                else{
                    if (nums[i - 1] < nums[j]){
                        swap(nums, i, j);
                        i++;
                    }
                    j++;
                }
            }
            return i;
        }

        public void swap(int[] nums, int k, int l){
            int tmp = 0;
            nums[k] = tmp;
            nums[k] = nums[l];
            nums[l] = tmp;
        }

    }

    public static void main(String[] args){

    }
}

public class LC041FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int i = 0;


        while (i < len){
            if (nums[i] <= 0 || nums[i] > len){
                nums[i] = 0;
                i++;
            } else{
                if (nums[i] == i + 1){
                    i++;
                }
                else if (nums[i] < i+1){
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = 0;
                    i++;
                } else{
                    if (nums[nums[i] - 1] != nums[i]){
                        swap (nums, i, nums[i] - 1);
                    } else{
                        nums[i] = 0;
                        i++;
                    }
                }
            }
        }

        for (int k = 0; k < len; k++){
            System.out.println(nums[k]);
            if (nums[k] == 0){
                return k + 1;
            }
        }
        return len + 1;
    }

    static void swap(int[] nums, int in1, int in2){
        int tmp = nums[in1];
        nums[in1] = nums[in2];
        nums[in2] = tmp;
    }
    public static void main(String[] args){
        System.out.println(firstMissingPositive(new int[]{2,2}));
    }

}

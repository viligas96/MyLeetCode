public class LC048JumpGameII {
    public static int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;

        int step = 0;
        int curMax = nums[0];
        int newMax = curMax;

        for (int i = 0; i < len; i++){
            if (i == curMax + 1) {
                step++;
                curMax = newMax;
            }
            if (i + nums[i] > newMax ){
                newMax = i + nums[i];
            }
        }
        step++;
        return step;
    }

    public static void main(String[] args){
        int[] test = new int[]{2,3,1,1,4};
        int[] test2 = new int[]{1,1,1,1};
        System.out.println(jump(test));
        System.out.println(jump(test2));
    }
}

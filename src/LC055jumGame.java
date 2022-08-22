public class LC055jumGame {
    //from front to back
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 1)return true;

        int[] dp = new int[len];
        int max_jump = nums[0];

        for (int i = 1; i < len; i++){
            if (i+max_jump >= len) return true;
            if (max_jump == 0) return false;
            if (max_jump <= 1 && nums[i] == 0) return false;
            max_jump = Math.max(max_jump - 1, nums[i]);
        }
        return false;
    }

    //from back to front
    public boolean canJump2(int[] nums) {
        int last = nums.length - 1, i;
        for(i = last - 1; i >= 0; i--){
            if(i + nums[i] >= last) last = i;
        }
        return last <= 0;
    }
}

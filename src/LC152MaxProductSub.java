public class LC152MaxProductSub {
    public int maxProduct(int[] nums) {
        int pos = Integer.MIN_VALUE;
        int conPos = Integer.MIN_VALUE;
        int minNeg = Integer.MIN_VALUE;
        int conNeg = Integer.MIN_VALUE;

        for (int i: nums){
            if (i == 0){
                pos = Math.max(pos, 0);
                conPos = Integer.MIN_VALUE;
                minNeg = Integer.MIN_VALUE;
                conNeg = Integer.MIN_VALUE;
            }
            if (i > 0){
                if (conPos == Integer.MIN_VALUE){
                    conPos = i;
                } else{
                    conPos *= i;
                }
                if (minNeg != Integer.MIN_VALUE){
                    minNeg *= i;
                }
                pos = Math.max(conPos, pos);
            }
            if (i < 0){
                if (minNeg == Integer.MIN_VALUE){
                    minNeg = i;
                }
                if (conPos != Integer.MIN_VALUE){
                    conNeg = conPos*i;
                    conPos = Integer.MIN_VALUE;
                }
                if (conNeg == Integer.MIN_VALUE){
                    conNeg = i;
                }
                if (conNeg != Integer.MIN_VALUE){
                    conNeg *= i;
                    conNeg /= minNeg;
                }
            }
        }

        return pos;
    }

    public int maxProductReal(int[] nums) {
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));

            max_so_far = temp_max;

            result = Math.max(max_so_far, result);
        }

        return result;
    }
}

public class leetcode {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 1; i< nums.length; i++) {
            for (int j = i; j<= nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    int[] answer = {i,j};
                    return answer;
                }
            }
        }
        return null;
    }
}

import java.util.*;
public class LC0163SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int ret = nums[0] + nums[1] + nums[2];
        int curDif = abs(ret- target);


        for (int i = 1; i <  2; i++){
            int sub_tar = target - nums[i];
            int left = i + 1;

            int min_dif = close(nums, left, sub_tar);
            if (min_dif == 0)return target;
            if (abs(min_dif) < abs(curDif))curDif = min_dif;
        }
        return target + curDif;
    }

    public int close(int[] nums, int left, int tar){
        int len = nums.length;
        int right = len - 1;

        int dif = nums[left] + nums[right] - tar;
        if (dif == 0) return 0;

        while (left < right - 1){
            int l_shift = nums[left + 1] + nums[right] - tar;
            int r_shift = nums[left] + nums[right -1] - tar;

            if (l_shift == 0 || r_shift == 0)return 0;

            System.out.println(l_shift);
            System.out.println(r_shift);

            if (abs(l_shift) <= abs(r_shift)) {
                if (abs(l_shift) <= abs(dif))dif = l_shift;
                left++;
            } else{
                if (abs(r_shift) <= abs(dif))dif = r_shift;
                right--;
            }
        }
        return dif;
    }

    public int abs(int i){
        return Math.abs(i);
    }

    public static  void main(String[] args){
        int[] nums = new int[]{-1000,-5,-5,-5,-5,-5,-5,-1,-1,-1};
        System.out.println(new LC0163SumClosest().threeSumClosest(nums, -14));

    }
}

import java.util.ArrayList;
import java.util.*;

public class LC046Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> tmp = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        tmp.add(sub);

        for (int i = 0; i <= len; i++) {
            for (List<Integer> list: ret){
                for (int num: nums){
                    if (!list.contains(num)){
                        List<Integer> nL = new ArrayList<>(list);
                        nL.add(num);
                        tmp.add(nL);
                    }
                }
            }
            ret = new ArrayList<>(tmp);
            tmp = new ArrayList<>();

        }

        return ret;
    }
    public static void main(String[] args){
        //System.out.println(permute(new int[]{1}));
        System.out.println(permute1(new int[]{1,2,3,4}));
    }

    public static List<List<Integer>> permute1(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        backTrack(nums, result, list);
        return result;
    }

    public static void backTrack(int[] nums, List<List<Integer>> result, List<Integer> list){
        if(list.size() == nums.length){
            //System.out.println("Return");
            result.add(new ArrayList<>(list));
            System.out.println(list);
            return;
        }
        //System.out.println("Size is "+nums.length);
        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i]))
                continue;
            list.add(nums[i]);

            backTrack(nums, result, list);
            //System.out.println(i);
            list.remove(list.size() - 1);
        }
    }

}

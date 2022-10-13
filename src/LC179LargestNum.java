import java.util.Arrays;
import java.util.Comparator;

public class LC179LargestNum {
    public static class comparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            String str1 = String.valueOf(o1);
            String str2 = String.valueOf(o2);

            String str3 = str1 + str2;
            String str4 = str2 + str1;

            return str4.compareTo(str3);
        }
    }

    public String largestNumber(int[] nums) {
        Integer[] convert = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++){
            convert[i] = nums[i];
        }
        Arrays.sort(convert, new comparator());

        StringBuilder ret = new StringBuilder();

        for (int j = 0; j < convert.length; j++){
            ret.append(convert[j]);
        }
        return ret.toString();
    }
}

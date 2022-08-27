import java.util.*;

public class LC084LargestRec {
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 1)return heights[0];



        return 0;
    }

    public static void main(String[] args){
        Integer[] arr = new Integer[]{1,2};

        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        list.add(3);
        System.out.println(list);
    }
}

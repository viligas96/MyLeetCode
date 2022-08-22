import java.util.*;
public class LC056MergeInterval {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        int len = intervals.length;
        if (len == 1) return intervals;

        List<int[]> ret = new ArrayList<>();
        ret.add(intervals[0]);

        for (int i = 1; i < len; i++) {
            int[] target = intervals[i].clone();

            List<int[]> tmp = new ArrayList<>(ret);
            System.out.println(Arrays.toString(ret.get(ret.size() - 1)));

            for (int[] list : tmp) {
                ret.remove(target);
                if (list[0] > target[1] || target[0] > list[1]) {
                    if (tmp.get(tmp.size()-1) == list ){
                    ret.add(target);}
                    continue;
                }
                if (target[0] <= list[0] && list[1]<=target[1]) {
                    ret.add(target);
                    ret.remove(list);
                    continue;
                }
                if (list[0] <= target[0] && target[1] <= list[1]){
                    break;
                }
                if (list[1] < target[1]) {
                    target = new int[]{list[0], target[1]};
                }
                else {
                    target = new int[]{target[0], list[1]};
                }
                ret.add(target);
                ret.remove(list);
            }
        }
        int[][] ret1 = new int[ret.size()][2];
        for (int i = 0; i < ret.size(); i++){
            ret1[i] = ret.get(i);
        }
        return ret1;
    }

    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        //recite how to use comparingInt method to sort int[]
        //Arrays.sort(intervals, Comparator.comparingInt(a->a[1]));
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main (String[] args){
        int[][] matrix1 = new int[][]{{2,3},{4,5},{0,1},{1,5}};
        System.out.println(Arrays.deepToString(merge(matrix1)));
    }
}

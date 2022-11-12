import java.util.*;
public class LC210CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashSet<Integer> restrict = new HashSet<>();

        for (int[] arr: prerequisites){
            restrict.add(arr[0]);
        }

        int[] ret = new int[numCourses];

        int ptr = 0;
        for (int i = 0; i < numCourses; i++){
            if (restrict.contains(i))continue;
            ret[ptr] = i;
            ptr++;
        }



        return ret;
    }
}

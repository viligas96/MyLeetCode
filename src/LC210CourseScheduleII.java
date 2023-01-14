import java.util.*;
public class LC210CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ret = new int[numCourses];
        if (prerequisites.length == 0){
            for (int i = 0; i < numCourses; i++){
                ret[i] = i;
            }
        }

        HashSet<Integer> needed = new HashSet<>();
        HashMap<Integer, HashSet<Integer>> restrictMap = buildMap(prerequisites);
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < numCourses; i++){ // Num Remained to be added
            needed.add(i);
        }

        while (needed.size() != 0){
            HashSet<Integer> tmp = new HashSet<>();

            for (int i: needed){
                if (!restrictMap.containsKey(i) || restrictMap.get(i).size() == 0){
                    order.add(i);
                    tmp.add(i);
                    update(i, restrictMap);
                }
            }


            if (tmp.size() == 0){
                return new int[]{};
            }
            for (int i: tmp){
                needed.remove(i);
            }

        }

        for (int i = 0; i < numCourses; i++){
            ret[numCourses - i - 1] = order.get(i);
        }

        return ret;
    }

    public static HashMap<Integer, HashSet<Integer>> buildMap(int[][] prerequisites){
        HashMap<Integer, HashSet<Integer>> ret = new HashMap<>();
        for (int[] i: prerequisites){
            if (!ret.containsKey(i[1])){
                HashSet<Integer> dependency = new HashSet<>();
                dependency.add(i[0]);
                ret.put(i[1], dependency);
            } else{
                ret.get(i[1]).add(i[0]);
            }
        }
        return ret;
    }

    public static void update(int input, HashMap<Integer, HashSet<Integer>> map){
        map.remove(input);
        for (int i: map.keySet()){
            map.get(i).remove(input);
        }
    }

/*    public static int[] findOrder2(int numCourses, int[][] prerequisites) {
        int[] ret = new int[numCourses];
        HashMap<Integer, Integer> degree = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < numCourses; i++){
            degree.put(i, 0);
        }

        Queue<Integer> order = new LinkedList<>();

        int index = 0;

        for (int[] i: prerequisites){
            if (map.containsKey(i[1])){
                map.get(i[1]).add(i[0]);
            } else{
                HashSet<Integer> tmp = new HashSet<>();
                tmp.add(i[0]);
                map.put(i[1], tmp);
            }
        }

        

        return ret;
    }*/

    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 0}, {2,0}, {3,1}, {3,2}};
        System.out.println(Arrays.toString(findOrder(4, test)));
    }
}

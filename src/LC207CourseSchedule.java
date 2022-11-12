import java.util.*;
public class LC207CourseSchedule {

    static class course{
        int classNum;
        boolean isDFSed = false;
        List<course> depend = new ArrayList<>();
        public course(int num){
            this.classNum = num;
        }
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> courseSet = new HashMap<>();

        for (int[] arr: prerequisites){
            if (courseSet.containsKey(arr[0])){
                courseSet.get(arr[0]).add(arr[1]);
            } else{
                List<Integer> list = new ArrayList<>();
                list.add(arr[1]);
                courseSet.put(arr[0], list);
            }
        }

        HashSet<Integer> checked = new HashSet<>();

        for (Integer i: courseSet.keySet()){
            HashSet<Integer> visited = new HashSet<>();
            if (dfs(i, courseSet,checked, visited))continue;
            return false;
        }
        return true;
    }

    public static boolean dfs(Integer cor, HashMap<Integer, List<Integer>> courseSet,HashSet<Integer>
            checked, HashSet<Integer> visited){

        if (visited.contains(cor))return false; //If already visited
        visited.add(cor);

        if (checked.contains(cor))return true;

        boolean ret = true;
        if (courseSet.containsKey(cor)){
            for(Integer i: courseSet.get(cor)){
                HashSet<Integer> tmpVisited = (HashSet) visited.clone();
                ret = ret && dfs(i, courseSet, checked, tmpVisited);
            }
        }
        checked.add(cor);
        return ret;
    }

    public static void main(String... args){
        int[][] test = new int[2][2];
        test[0][0] = 1;
        test[0][1] = 2;
        test[1][0] = 2;
        test[1][1] = 1;
        System.out.println(canFinish(4, test));
    }

}

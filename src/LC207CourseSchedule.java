import java.util.*;
public class LC207CourseSchedule {

    static class course{
        int classNum;
        List<course> depend = new ArrayList<>();
        List<course> support = new ArrayList<>();
        public course(int num){
            this.classNum = num;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] arr: prerequisites){
            int cour = arr[0];
            int pre = arr[1];
            if (graph.containsKey(cour)){
                graph.get(cour).add(pre);
            } else{
                LinkedList<Integer> Pre = new LinkedList<>();
                Pre.add(pre);
                graph.put(cour, Pre);
            }
        }

        for (Integer in: graph.keySet()){
            if ()
        }




        return true;
    }

}

import java.util.*;
public class LC743NetworkDelayTime {
    public class Node{
        public int num;
        public boolean isReached;
        public int time;
        public HashMap<Integer, Integer> edge = new HashMap<>();

        public Node(int num){
            this.num = num;
            this.time = 0;
            this.isReached = false;
            this.edge = new HashMap<>();
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        HashSet<Integer> NodeSet = new HashSet<>();

        for (int[] i: times){
            if (NodeSet.contains(i[1]))continue;
            NodeSet.add(i[1]);
        }
        if (NodeSet.size() < n - 1)return -1;



        return 0;
    }
}

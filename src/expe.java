import java.util.*;
public class expe {
    public static long getTotalEfficiency(List<Integer> skill) {
        // Write your code here
        int total = 0;
        int teamNum = skill.size()/2;
        if (teamNum * 2 != skill.size()) return -1;

        for (Integer sk: skill){
            total += sk;
        }
        if (total % teamNum != 0) return -1;

        int pairVal = total/teamNum;

        long ret = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer sk: skill){
            if (map.containsKey(sk)){
                map.put(sk, map.get(sk) + 1);
            } else{
                map.put(sk, 1);
            }
        }
        for (Integer sk: skill){
            if (!map.containsKey(pairVal - sk))return -1;
            ret += (long) sk * (pairVal - sk);

            if (map.get(pairVal - sk) == 1){
                map.remove(pairVal - sk);
            } else{
                map.put((pairVal - sk), map.get(pairVal - sk) - 1);
            }

        }

        return ret/2;
    }

    public static long getMinimumHealth(List<Integer> initial_players, List<Integer> new_players, int rank) {
        // Write your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (Integer ini : initial_players) {
            if (minHeap.size() >= rank) {
                minHeap.add(ini);
                minHeap.poll();
            } else{
                minHeap.add(ini);
            }
        }
        long ret = 0;
        ret += minHeap.peek();

        for (Integer newP: new_players){
            minHeap.add(newP);
            minHeap.poll();
            ret += minHeap.peek();
        }
        return ret;
    }

    public static void main(String... args) {
        List<Integer> i = new ArrayList<>();
        i.add(1);
        i.add(2);
        i.add(3);
        List<Integer> j = new ArrayList<>();
        j.add(6);
        j.add(5);
        j.add(4);

        System.out.println(getMinimumHealth(i,j,1));
    }

}
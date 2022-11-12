import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class BlackRock2 {
    /**
     * The Main class implements an application that reads lines from the standard input
     * and prints them to the standard output.
     */
    public static double DFS(String origin, String target, double rate,
                      HashMap<String, HashMap<String, Double>> map, HashSet<String> visited){
        if (!map.containsKey(origin) || !map.containsKey(target)
                || visited.contains(origin))return -1.0;

        visited.add(origin);
        if (origin.equals(target))return rate;

        double Max_ret = -1.00;

        for (String str: map.get(origin).keySet()){
            double newRate = rate * map.get(origin).get(str);
            HashSet<String> tmp = (HashSet<String>)visited.clone();
            double ret = DFS(str, target, newRate, map, tmp);
            if (ret > Max_ret)Max_ret = ret;
        }
        return Max_ret;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

        String str1; //Input String for parsing
        String origin; //Origin currency
        String target; //Target currency

        line = in.readLine();
        str1 = line;
        line = in.readLine();
        origin = line;
        line = in.readLine();
        target = line;

        HashMap<String, HashMap<String, Double>> map = new HashMap<>();

        String[] equation = str1.split(";"); //Get each equation
        for (String sig: equation){
            String[] result = sig.split(","); //Get each part inside each equation
            String cur1 = result[0];
            String cur2 = result[1];
            double rate = Double.parseDouble(result[2]);
            if (!cur1.equals(origin) && !cur2.equals(origin) && !cur1.equals(target)
                    && !cur2.equals(target))continue; //skip this equation if no currency related.
            //save the rate from cur1 to cur2
            if (map.containsKey(cur1)){
                map.get(cur1).put(cur2, rate);
            } else{
                HashMap<String, Double> tmp = new HashMap<>();
                tmp.put(cur2, rate);
                map.put(cur1, tmp);
            }
            //save the rate from cur2 to cur1
            if (map.containsKey(cur2)){
                map.get(cur2).put(cur1, 1/rate);
            } else{
                HashMap<String, Double> tmp = new HashMap<>();
                tmp.put(cur1, 1/rate);
                map.put(cur2, tmp);
            }
        }
        HashSet<String> visited = new HashSet<>();
        System.out.println(DFS(origin, target, 1.00, map, visited));
    }
}

import java.util.*;
public class LC399EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> totalList = new HashMap<>();

        for (int i = 0; i < equations.size(); i++){
            List<String> tmpList = equations.get(i);
            String A = tmpList.get(0);
            String B = tmpList.get(1);
            // Save the rate from B to A
            if (!totalList.containsKey(A)) {
                HashMap<String, Double> tmp = new HashMap<>();
                tmp.put(B, values[i]);
                totalList.put(A, tmp);
            } else{
                HashMap<String, Double> exist = totalList.get(A);
                exist.put(B, values[i]);
            }
            // Save the rate from A to B
            if (!totalList.containsKey(B)) {
                HashMap<String, Double> tmp = new HashMap<>();
                tmp.put(A, 1/values[i]);
                totalList.put(B, tmp);
            } else{
                HashMap<String, Double> exist = totalList.get(B);
                exist.put(A, 1/values[i]);
            }
        }
        // Initialize return double array
        int retLen = queries.size();
        double[] ret = new double[retLen];
        // Calculate the result for each query
        for (int j = 0; j < retLen; j++){
            String start = queries.get(j).get(0);
            String target = queries.get(j).get(1);

            HashSet<String> visited = new HashSet<>();
            ret[j] = BFS(start, target, 1.00,totalList, visited);
        }
        return ret;
    }

    public double BFS(String start, String target, double coEff,
                      HashMap<String, HashMap<String, Double>> totalList, HashSet<String> visited){
        if (!totalList.containsKey(start) || !totalList.containsKey(target)
                || visited.contains(start))return -1.0;
        visited.add(start);
        if (start.equals(target))return coEff;

        for (String str: totalList.get(start).keySet()){
            double newCo = coEff * totalList.get(start).get(str);
            double ret = BFS(str, target, newCo, totalList, visited);
            if (ret > 0)return ret;
        }

        return -1.00;
    }
}

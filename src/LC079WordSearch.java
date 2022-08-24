import java.util.*;
public class LC079WordSearch {
    public static boolean exist(char[][] board, String word) {
        boolean[] find = new boolean[]{false};

        char first = word.charAt(0);
        List<ArrayList<Integer>> range = new ArrayList<>();
        HashSet<ArrayList<Integer>> visited = new HashSet<>();

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == first){
                    ArrayList<Integer> fir = new ArrayList<>();
                    fir.add(i);
                    fir.add(j);
                    range.add(fir);
                }
            }
        }

        for (ArrayList<Integer> cur: range) {
            visited.add(cur);
            dfs(board, visited, cur, word, 1, find);
            visited.remove(cur);
        }
        return find[0];
    }

    public static void dfs(char[][] board, HashSet<ArrayList<Integer>> visited, ArrayList<Integer> cur,
                           String word, int index, boolean[] find){
        if (index == word.length()) {find[0] = true; return;}
        if (find[0]) return;

        List<ArrayList<Integer>> range = new ArrayList<>();
        List<ArrayList<Integer>> range2 = new ArrayList<>();

        ArrayList<Integer> p1 = new ArrayList<>(); p1.add(cur.get(0)); p1.add(cur.get(1) + 1);
        ArrayList<Integer> p2 = new ArrayList<>(); p2.add(cur.get(0)); p2.add(cur.get(1) - 1);
        ArrayList<Integer> p3 = new ArrayList<>(); p3.add(cur.get(0) + 1); p3.add(cur.get(1));
        ArrayList<Integer> p4 = new ArrayList<>(); p4.add(cur.get(0) - 1); p4.add(cur.get(1));

        range2.add(p1); range2.add(p2); range2.add(p3); range2.add(p4);

        for (ArrayList<Integer> pair: range2){
            if (!(pair.get(0) < 0 || pair.get(0) >= board.length ||
                    pair.get(1) < 0 || pair.get(1) >= board[0].length)){
                if (board[pair.get(0)][pair.get(1)] == word.charAt(index)&& !visited.contains(pair)){
                        range.add(pair);}
            }
        }

        for (ArrayList<Integer> pair2: range){
            visited.add(pair2);
            dfs(board, visited, pair2, word, index + 1, find);
            visited.remove(pair2);
        }
    }


    public static void main(String[] args){
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));

    }

}

import java.util.*;

class Solution {

    public Solution(){
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int par = 0;
        ParGen(result, "", 2*n, 0);
        return result;
    }

    public void ParGen(List<String> result, String prefix, int remain_len, int par){
        if (par < 0 || remain_len < par){
            return;
        }
        if (remain_len == 0){
            result.add(prefix);
            return;
        }
        ParGen(result, prefix+'(', remain_len-1, par + 1);
        ParGen(result, prefix+')', remain_len-1, par - 1);
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.generateParenthesis(4));

        System.out.println(Math.sqrt(Math.pow(3, 2) + Math.pow(4, 2)));
    }
}
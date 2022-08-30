import java.util.*;
public class LC118PascalTri {
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
        List<Integer> fRow = new ArrayList<>();
        fRow.add(1);
        ret.add(fRow);
        if (numRows == 1)return ret;

        for (int curR = 2; curR <= numRows; curR++){
            List<Integer> curList = new ArrayList<>();
            curList.add(1);
            for (int i = 1; i < curR-1; i++){
                curList.add(i, ret.get(curR-2).get(i - 1) + ret.get(curR -2).get(i));
            }
            curList.add(1);
            ret.add(curList);
        }
        return ret;
    }
    public static void main(String[] args){
        System.out.println(new LC118PascalTri().generate(4));
    }
}

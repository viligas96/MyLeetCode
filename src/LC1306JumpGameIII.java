import java.util.HashSet;

public class LC1306JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        int len = arr.length;
        int[] pass = new int[len];

        jump(arr, start, pass);

        HashSet<Integer> ret = new HashSet<>();
        for (int i = 0; i < len; i++){
            if (arr[i] == 0){
                ret.add(i);
            }
        }
        for (Integer i: ret){
            if (pass[i] == 1)return true;
        }
        return false;
    }

    public void jump(int[] arr, int cur, int[] pass){
        if (cur < 0 || cur >= arr.length || pass[cur] == 1)return;
        if (pass[cur] == 0){
            pass[cur] = 1;
        }
        jump(arr, cur + arr[cur], pass);
        jump(arr, cur- arr[cur], pass);
    }

}

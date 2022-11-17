public class LC6502KeyKeyBoard {
    public int minSteps(int n) {
        if (n == 1)return 0;
        return recur(1, 1,n);
    }

    public int recur(int cur, int paste, int i){
        if (cur == i) return 1;
        if (cur > i) return Integer.MIN_VALUE;

        if (cur == paste)return recur(cur + paste, paste, i) + 1;

        int ctrlC = recur(cur, cur, i) + 1;
        int ctrlV = recur(cur + paste, paste, i) + 1;

        if (ctrlC < 0)return ctrlV;
        if (ctrlV < 0)return ctrlC;
        return Math.min(ctrlC, ctrlV);
    }
}

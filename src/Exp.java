public class Exp {
    public static class amount{
        public static int count(int zero, int one, int min, int max){
            int[] log = new int[max + 1];
            return recur(zero, one, min, max, 0, log);
        }

        public static int recur(int zero, int one, int min, int max, int curLen, int[] log){
            if (curLen > max){
                return 0;
            } else{
                int cur;
                if (log[curLen] != 0){
                    cur = log[curLen];
                } else {
                    cur = recur(zero, one, min, max, curLen + zero, log) + recur(zero, one, min, max, curLen + one, log);
                    log[curLen] = cur;
                }
                if (curLen >= min){
                    return cur + 1;
                } else{
                    return cur;
                }
            }
        }
    }
    public static void main(String[] args){
        System.out.println(amount.count(3,3,4,6));
    }
}

public class LC204CountPrime {
    public int countPrimes(int n) {
        if (n <= 2)return 0;
        int ret = 0;

        int start = 2;

        while (start < n){
            int i = 2;
            while (i < start){
                if (start % i == 0){
                    break;
                }
                i++;
            }
            if (i == start)ret++;

            start++;
        }
        return ret;
    }
    public static void main(String[] args){
        Character a = 'a';
        Character b = 'a';
        System.out.println(a.equals(b));
    }
}

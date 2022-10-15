import java.util.*;
public class LC202HappyNum {
    public HashSet<Integer> set= new HashSet<>();
    public boolean isHappy(int n) {
        if (n == 1)return true;
        if (set.contains(n))return false;
        set.add(n);

        int transfer = 0;
        while (n > 0){
            transfer += (n%10)*(n%10);
            n /= 10;
        }

        return isHappy(transfer);
    }
}

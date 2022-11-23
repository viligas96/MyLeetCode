import java.util.*;
public class LC412fizzBuzz {
        public List<String> fizz(int n) {
            List<String> ret = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                if (i % 15 == 0){
                    ret.add("FizzBuzz");
                    continue;
                }
                if (i % 5 == 0){
                    ret.add("Buzz");
                    continue;
                }
                if (i % 3 == 0){
                    ret.add("Fizz");
                    continue;
                }
                ret.add(i+"");
            }
            return ret;
        }
}

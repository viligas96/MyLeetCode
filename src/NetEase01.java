public class NetEase01 {
    // NetEase interview coding problem:
    // a and b are 2 integers. Remove one digit from either integers.
    // To make the rest 2 integers: at least one integer can be divided by another with no remainder.
    public static int minOperation(int a, int b){
        return process(a, b, 0);
    }

    static int process(int a, int b, int oper){
        if (a==0||b==0||a%b == 0 || b %a == 0){
            return  oper;
        }

        int aDig = 0;
        int bDig = 0;

        while ( a > 0){
            a /= 10;
            aDig += 1;
        }

        while (b > 0){
            b /= 10;
            bDig += 1;
        }

        int DigMin =  Math.min(aDig, bDig);

        return Math.min(process(a,b,aDig), DigMin);
    }
}

public class divide {
    public static int divide(int dividend, int divisor) {

        long di1 = Math.abs(dividend);
        if (dividend == Integer.MIN_VALUE){
            if (divisor == -1){return Integer.MAX_VALUE;}
            if (divisor == Integer.MIN_VALUE){return 1;}
            di1 = Integer.MIN_VALUE;
            di1 = -di1;
        }
        if (divisor == Integer.MIN_VALUE){
            return 0;
        }

        long di2 = Math.abs(divisor);

        if (di1 < di2){return 0;}
        if (di1 == di2){return ((dividend > 0)^(divisor>0))? -1:1;}

        if (divisor == 1){
            return dividend;
        }
        if (divisor == -1){
            return -dividend;
        }

        int i = 0;
        long powdi2 = di2;
        int pow2 = 1;


        while (di1 >= di2){

            if (di1 < powdi2){
                pow2 >>=1;
                powdi2 >>=1;
                continue;
            }

            di1 -= powdi2;
            i += pow2;
            pow2 <<= 1;
            powdi2 <<= 1;
        }

        i = ((dividend > 0)^(divisor>0))? -i:i;

        return i;
    }

    public static void main(String[] args){
        System.out.println(divide(100,-5));
    }
}

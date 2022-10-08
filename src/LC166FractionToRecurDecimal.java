public class LC166FractionToRecurDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        double row = (double)numerator/(double)denominator;
        int integer = (int)row;

        StringBuilder ret = new StringBuilder(integer + "");
        if (integer == row)return ret.toString();

        ret.append(".");
        double deci = row - integer;
        while (deci * 10 < 1){
            ret.append("0");
            deci *= 10;
        }
        ret.append(deci);

        return ret.toString();
    }

    public static void main(String[] args){
        System.out.println(fractionToDecimal(4,3));
        System.out.println(4.0 - 4 == 0);
        System.out.println();
    }
}

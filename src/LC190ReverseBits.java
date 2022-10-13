public class LC190ReverseBits {
    public static int reverseBits(int n) {
        String i = Integer.toBinaryString(n);

        StringBuilder ret = new StringBuilder();

        for (int j = i.length() - 1; j >= 0; j--){
            ret.append(i.charAt(j));
        }
        String rev = ret.toString();

        while (rev.length() < 32){
            rev += "0";
        }
        return (int)Long.parseLong(rev, 2);
    }
    public static void main(String... args){
        //System.out.println(Integer.parseInt("011111111111111111111111111111110", 2));
        System.out.println(reverseBits((int)Long.parseLong("11111111111111111111111111111101", 2)));
    }
}
public class LC038CountSay {
    public static String countAndSay(int n) {
        return process("1", n);
    }
    static String process(String str, int n){
        if (n == 1){
           return str;
        }
        else {
            StringBuilder ret = new StringBuilder();
            int count = 1;
            if (str.length() == 1){
                ret.append(1).append("1");
                return process(ret.toString(), n-1);
            }

            for (int i = 0; i + 1< str.length(); i++){
                if (str.charAt(i) == str.charAt(i+1)){
                    count++;
                } else{
                    ret.append(count).append(str.charAt(i));
                    count = 1;
                }
            }
            ret.append(count).append(str.charAt(str.length()-1));
            return process(ret.toString(), n -1);
        }
    }
    public static void main(String[] args){
        System.out.println(countAndSay(6));
    }
}

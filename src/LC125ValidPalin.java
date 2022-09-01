import java.util.HashSet;

public class LC125ValidPalin {
    public static boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0;
        int right = s.length() - 1;


        while (left <= right){
            if (validChar(s.charAt(left)) && s.charAt(left) - 'a' >= -49 && s.charAt(left) - 'a' <= -40){
                while (!validChar(s.charAt(right))){
                    right--;
                }
                if (s.charAt(left) != s.charAt(right)){
                    return false;
                }
                right--;
            }
            if (validChar(s.charAt(left)) && !(s.charAt(left) - 'a' >= -49 && s.charAt(left) - 'a' <= -40)){
                while (!validChar(s.charAt(right))){
                    right--;
                }
                char L = Character.toLowerCase(s.charAt(left));
                char R = Character.toLowerCase(s.charAt(right));
                if (L != R){
                    return false;
                }
                right--;
            }
            left++;
        }
        return true;
    }

    public static boolean validChar(char ch) {
        return (ch - 'a' >= 0 && ch - 'a' <= 25)||(ch - 'a' <= -7 && ch - 'a' >= -32)
                ||(ch - 'a' >= -49 && ch - 'a' <= -40);
    }

    public static void main(String[] args){
        //System.out.println('0' -'a');
        //System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(isPalindrome("0P"));
        System.out.println(isPalindrome("1b1"));
    }


}

public class strStr {
    public static int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();

        if (len2 == 0){
            return 0;
        }

        for (int i = 0 ; i < len1; i++){
            if (i + len2 > len1){
                return -1;
            }
            for (int j = 0; j < len2; j++){
                if (haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
                if (j == len2 - 1){
                    return i;
                }
            }

        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(strStr("123","123"));
    }
}

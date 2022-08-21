public class LC044WildcardM {
    public static boolean isMatch(String s, String p) {

        return aster(s, p);
    }

    // p doesn't have "*"
    static boolean equal(String s, String p){
        if (s.length() != p.length()){return false;}
        for (int i = 0; i < s.length(); i++){
            if (p.charAt(i) != s.charAt(i) && p.charAt(i) != '?'){
                return false;
            }
        }
        return true;
    }

    // p does have "*"
    static boolean aster(String s, String p){
        // base case
        if (p.equals(s)) return true;
        if (!p.contains("*")) return equal(s, p);
        if (s.length() == 0){
            for (int i = 0; i < p.length(); i++){
                if (p.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(aster("", "**"));
    }
}

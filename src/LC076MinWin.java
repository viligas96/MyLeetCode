import java.util.*;

public class LC076MinWin {
    public static String minWindow(String s, String t) {
        if (s.length() < t.length())return "";

        String ret = "";
        s = s+ "1";

        HashMap<Character, Integer> Tmap = new HashMap<>();
        for (char ch: t.toCharArray()){
            if (Tmap.containsKey(ch)){
                Tmap.put(ch,Tmap.get(ch) + 1);
            } else{
                Tmap.put(ch,1);
            }
        }

        int left = 0;
        int right = t.length();

        for (int i = 0; i < t.length(); i++){
            if (Tmap.containsKey(s.charAt(i))){
                Tmap.put(s.charAt(i), Tmap.get(s.charAt(i)) - 1);
            }
        }

        while (right < s.length()){
            if (checkMap(Tmap)) {
                System.out.println(left+"-"+right);

                if (ret.length() > right - left || ret.equals("")){
                    ret = s.substring(left,right);
                }

                if (right - left == t.length()) {
                    return ret;
                }

                if (!Tmap.containsKey(s.charAt(left))){
                    left++;
                }
                else{
                    if (Tmap.get(s.charAt(left)) < 0){
                        Tmap.put(s.charAt(left), Tmap.get(s.charAt(left)) + 1);
                        left++;
                        continue;
                    }
                    if (Tmap.containsKey(s.charAt(right))){
                        Tmap.put(s.charAt(right), Tmap.get(s.charAt(right)) - 1);
                    }
                    right++;
                }
            }


            else{
                if (Tmap.containsKey(s.charAt(right))){
                    Tmap.put(s.charAt(right), Tmap.get(s.charAt(right)) - 1);
                }
                right++;
            }
        }
        System.out.println(left);
        System.out.println(right);
        return ret;
    }

    public static boolean checkMap(HashMap<Character, Integer> map){
        for (char ch: map.keySet()){
            if (map.get(ch) > 0){return false;}
        }
        return true;
    }


    public static void main(String[] args){


        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}

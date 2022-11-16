import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Op2 {
    static boolean check1(String s){
        if ((s.length() + 1)%6 != 0) return false; // format length = (len)(pair + whitespace) * pair_num - 1 = 5 * num - 1
        String[] pairs = s.split(" ");
        for (String str: pairs){
            if (str.length() != 5)return false; //fixed length for each pair and no extra substring inside
            if (str.charAt(0) != '(' || str.charAt(2) != ',' || str.charAt(4) != ')')return false; //fixed format of input string
            if (str.charAt(1) - 'A' < 0 || str.charAt(1) - 'A' > 25)return false; // Parents must be
            if (str.charAt(3) - 'A' < 0 || str.charAt(3) - 'A' > 25)return false;
        }
        return true;
    }

    static boolean check2(String s){
        String[] pairs = s.split(" ");
        HashSet<String> set = new HashSet<>();
        for (String str: pairs){
            if (set.contains(str))return false;
            set.add(str);
        }
        return true;
    }

    static boolean check3(String s){
        String[] pairs = s.split(" ");
        HashMap<Character, Integer> parentMap = new HashMap<>();
        for (String str: pairs){
            char parent = str.charAt(1);
            Set<Character> set= parentMap.keySet();
            if (!set.contains(parent)){
                parentMap.put(parent, 1);
            } else{
                if (parentMap.get(parent) == 1){
                    parentMap.put(parent, 2);
                } else{
                    return false;
                }
            }
        }
        return true;
    }

    static boolean check4(String s){
        String[] pairs = s.split(" ");
        HashSet<Character> parent = new HashSet<>();
        HashSet<Character> children = new HashSet<>();

        for (String str: pairs){
            parent.add(str.charAt(1));
            children.add(str.charAt(3));
        }

        int notLeaf = parent.size(); // Num of node with children
        int notRoot = 0; // Num of node with children in Children set

        for (Character p: parent){
            if (children.contains(p)) notRoot++;
        }

        //If there are multiple roots, then more than 1 character in parent set don't belong to child set
        // I don't know whether situation like (A, B) (B,A) belongs to E4 or E5. Here I let this to be E5.
        return notLeaf <= notRoot + 1;
    }

    static boolean check5(String s){
        String[] pairs = s.split(" ");
        HashSet<Character> total = new HashSet<>();

        for (String str: pairs){
            total.add(str.charAt(1));
            total.add(str.charAt(3));
        }
        return pairs.length == total.size() - 1;
    }

    static String checkTotal(String input){
        if (check1(input)){
            if (check2(input)){
                if (check3(input)){
                    if (check4(input)){
                        if (!check5(input)) return "E5";
                    } else{
                        return "E4";
                    }
                } else{
                    return "E3";
                }
            } else{
                return "E2";
            }
        } else{
            return "E1";
        }
        return "None";
    }

    static char findRoot(String s){
        String[] pairs = s.split(" ");
        HashSet<Character> parent = new HashSet<>();
        HashSet<Character> children = new HashSet<>();

        char ret = 'a';

        for (String str: pairs){
            parent.add(str.charAt(1));
            children.add(str.charAt(3));
        }


        for (Character p: parent){
            if (!children.contains(p)){
                ret = p;
                break;
            }
        }
        return ret;
    }

    static String sExpression(HashMap<Character, Character[]> totalMap, Character cur){
        if (cur == 'a')return "";
        if (!totalMap.containsKey(cur)){ // Character cur is a leaf node.
            StringBuffer ret = new StringBuffer();
            ret.append('(');
            ret.append(cur);
            ret.append(')');
            return ret.toString();
        }
        Character first = totalMap.get(cur)[0]; //First child
        Character second = totalMap.get(cur)[1]; // Second child

        return cur.toString() + "(" + sExpression(totalMap, first) + sExpression(totalMap, second) + ")";
    }

    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        //
        String wrongType = checkTotal(input);

        if (wrongType.equals("None")){
            //Implementation of the establishment of S-Expression Representation.
            //Precondition: the input string is valid.
            String[] pairs = input.split(" ");
            HashMap<Character, Character[]> totalMap = new HashMap<>();
            for (String str: pairs){
                Character parent = str.charAt(1);
                Character child = str.charAt(3);
                if (totalMap.containsKey(parent)){
                    totalMap.get(parent)[1] = child;
                } else{
                    Character[] ch = new Character[2];
                    ch[0] = child;
                    ch[1] = 'a';
                    totalMap.put(parent, ch);
                }
            }
            Character root = findRoot(input);
            System.out.println(sExpression(totalMap, root));
        } else{
            System.out.println(wrongType);
        }
    }
}

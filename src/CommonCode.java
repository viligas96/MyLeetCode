import java.util.*;
import java.io.*;

public class CommonCode {
    // Unimproved version of disjointSet
    public static class disjointSet{
        private final int value;
        private disjointSet parent;

        public disjointSet(int val){
            this.value = val;
            this.parent = this;
        }

        boolean isSameSet(disjointSet set){
            disjointSet p1 = set.parent;
            disjointSet p2 = this.parent;

            while (p1.parent != p1){
                p1 = p1.parent;
            }
            while (p2.parent != p2){
                p2 = p2.parent;
            }
            return p1 == p2;
        }

        void merge(disjointSet set){
            this.parent.parent = set.parent;
        }
    }
    // Comparator
    public static class comparator implements Comparator<int[]>{
        @Override
        public int compare(int[] arr1, int[] arr2){
            // things to implement: compare
            return 0;
        }

        public void sort(){
            Integer[] output = new Integer[]{1,2,3};
            System.out.println(Arrays.deepToString(output));
            // Third: Sort the array with the new Comparator class;
            //Arrays.sort(output, new comparator());
            System.out.println(Arrays.deepToString(output));
        }
    }
    // create class with generic
    public static class cla<E>{
        public int value;
        public E anyData;

        public cla(int value, E data){
            this.value = value;
            this.anyData = data;
        }
    }
    // String buffer:
    public static void strBuff(){
        StringBuilder sB = new StringBuilder();
        sB.append(new char[]{'a', 'g', 'd'});
        sB.deleteCharAt(sB.length() - 1);
        System.out.println();
    }

    //Initialize data structure:
    public static void initial() {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        //
    }

    public static void main(String[] args){
        int  i = 1;
        i = i++;
        System.out.println(i);
        //Scanner S = new Scanner(System.in);
        //String s = S.nextLine();
        String a = "123";
        String c = "123";
        String b = new String("123");
        System.out.println(a == b);
        System.out.println(a == c);

        HashSet<String> set = new HashSet<>();

        Object obj = new StringBuilder("");
        System.out.println(obj.getClass());

        System.out.println("abc\rcde\nfgh");

        File file = new File("D:\\Algorithm and data structure\\abcd.txt");
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e){
            System.out.println("failed");
        }
    }
}

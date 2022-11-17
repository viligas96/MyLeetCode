import java.util.*;

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
    public static class comparator implements Comparator<Integer>{
        @Override
        public int compare(Integer arr1, Integer arr2){
            // things to implement: compare
            return 0;
        }

        public void sort(){
            Integer[] output = new Integer[]{1,2,3};
            System.out.println(Arrays.deepToString(output));
            // Third: Sort the array with the new Comparator class;
            Arrays.sort(output, new comparator());
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
        strBuff();
        Scanner S = new Scanner(System.in);
        String s = S.nextLine();


    }
}

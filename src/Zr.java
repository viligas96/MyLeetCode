public class Zr {
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

    static boolean whetherEqual(int x, int y){
        // Implement the method to determine whether i and j are equal under a certain rules.
        String str1 = x + "";
        String str2 = y + "";
        if (str1.length() != str2.length())return false;
        int len = str1.length();

        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                int index = i + j;
                if (i + j >= len) index-=len;

                if (str1.charAt(index) != str2.charAt(j)) break;

                if (j == len - 1)return true;
            }
        }
        return false;
    }

    static long findNum(int[] a){
        int len = a.length;
        long ret = 0;
        disjointSet[] list = new disjointSet[len];

        for (int i = 0; i < len; i++){
            list[i] = new disjointSet(a[i]);
        }

        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                if (list[i].isSameSet(list[j])){
                    ret++;
                } else {
                    if (whetherEqual(list[i].value, list[j].value)) {
                        list[i].merge(list[j]);
                        ret++;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String... args){
        int[] A = {1234, 2341, 3412, 4123, 456, 564, 645};
        System.out.println(findNum(A));
    }
}

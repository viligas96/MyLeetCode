public class test {
    public static class stat{
        public stat(){
            System.out.println(123);
        }

        public static int ret() {
            return 1;
        }
    }

    public class vari{
        int self;
        public vari(){
            this.self = 0;
            System.out.println(456);
        }
    }

    public int ret(){
        vari var = new vari();
        return 1;
    }

    public static void main(String[] args){
        test t = new test();
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        String d = "ab" + "c";

        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(c==d);
        a = "1";
        System.out.println(b==d);

        Integer aa = 1;
        Integer bb = 1;
        Integer cc = new Integer(1);
        System.out.println(aa == bb);
        System.out.println(aa == cc);
    }

}

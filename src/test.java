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

    }

}

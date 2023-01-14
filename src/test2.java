public abstract class test2 {

/*    void run(test2 te) {
        System.out.println("original");
    }*/

    public static void main(String[] args) {
        test2 a = new test2(){
            void run(test2 te){
                System.out.println("override");
            }
        };

        System.out.println(a instanceof test2); // Always true
        System.out.println(a.getClass());
    }
}

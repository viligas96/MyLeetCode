public class Parent<T> {
    private T i;
    public Parent(T t) {
        this.i = t;
    }

    public <T> void getKey(){};
}

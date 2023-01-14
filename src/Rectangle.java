import java.util.*;

public class Rectangle {
    private List<Double[]> history;
    private int ptr;
    private boolean isFirst;

    public Rectangle(double x, double y, double length, double width){
        Double[] tmp = new Double[4];
        tmp[0] = x;
        tmp[1] = y;
        tmp[2] = length;
        tmp[3] = width;
        this.history = new LinkedList<>();
        this.history.add(tmp);
        this.ptr = 0;
        this.isFirst = true;
    }

    public void setX(double x) {
        Double[] cur = this.history.get(ptr);
        Double[] tmp = new Double[4];
        tmp[0] = x;
        tmp[1] = cur[1];
        tmp[2] = cur[2];
        tmp[3] = cur[3];
        this.history.add(tmp);
        this.ptr++;
        this.isFirst = false;
    }

    public void scaleSize(double scaleFactor){
        Double[] cur = this.history.get(ptr);
        Double[] tmp = new Double[4];
        tmp[0] = cur[0];
        tmp[1] = cur[1];
        tmp[2] = scaleFactor * cur[2];
        tmp[3] = scaleFactor * cur[3];
        this.history.add(tmp);
        // this.cur.next = tmp;
        // this.cur = this.cur.next;
        this.ptr++;
        this.isFirst = false;
    }

    public void undo(){
        if (this.isFirst){
            System.out.println("This is already the initial state");
            return;
        }
        this.ptr--;
        if (this.ptr == 0){
            //this.cur.prev == null
            this.isFirst = true;
        }
    }
}

import java.util.*;
public class LC138CopyListwithRandomPtr {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static Node copyRandomList(Node head) {
        if (head.next == null)return head;

        List<Node> list1 = new LinkedList<>();
        List<Node> list2 = new LinkedList<>();

        Node newHead = deepCopy(head);
        Node cur1 = head;
        Node cur2 = newHead;

        list1.add(cur1);
        list2.add(cur2);

        while (cur1.next != null){
            list1.add(cur1.next);
            cur2.next = deepCopy(cur1.next);
            list2.add(cur2.next);

            cur2 = cur2.next;
            cur1 = cur1.next;
        }
        Node cur3 = head;
        Node cur4 = newHead;

        while (cur3.next != null){
            cur4 = cur4.next;
            cur3 = cur3.next;
            if (cur3.random != null){
                cur4.random = list2.get(list1.indexOf(cur3.random));
            }
        }

        return newHead;
    }

    public static Node deepCopy(Node node){
        if (node == null)return null;
        return new Node(node.val);
    }

    public static void main(String[] args){
        List<Node> list = new LinkedList<>();
        Node a = new Node(7);
        Node b = new Node(13);
        Node c = new Node(11);
        Node d = new Node(10);
        Node e = new Node(1);
        a.next = b; a.random = null;
        b.next = c; b.random = a;
        c.next = d; c.random = e;
        d.next = e; d.random = c;
        e.random = a;

        copyRandomList(a);
    }
}

import java.util.*;

public class LC148SortList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode sortList(ListNode head) {
        if (head == null)return null;
        PriorityQueue<ListNode> list = new PriorityQueue<>(new comparator());
        ListNode cur = head;
        while (cur != null){
            list.add(cur);
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = null;
        }
        ListNode newHead = list.poll();
        ListNode tail = newHead;

        while (list.peek() != null){
            cur = list.poll();
            tail.next = cur;
            tail = tail.next;
        }
        return newHead;
    }
    public static class comparator implements Comparator<ListNode>{
        @Override
        public int compare(ListNode node1, ListNode node2) {
            return node1.val - node2.val;
        }
    }

    public static void main(String[] args){
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(6);
        ListNode c = new ListNode(4);
        a.next = b;
        b.next = c;

        //System.out.println(sortList(a).val);
        //System.out.println(sortList(a).next.val);
        System.out.println(sortList(a).next.next.next.val);
    }
}
